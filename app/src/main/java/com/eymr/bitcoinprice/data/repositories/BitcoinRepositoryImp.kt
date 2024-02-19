package com.eymr.bitcoinprice.data.repositories

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.data.services.IServicesAPI
import com.eymr.bitcoinprice.domain.repositories.ErrorResponse
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import com.eymr.bitcoinprice.models.bitcoinprice.Bitcoin
import com.eymr.bitcoinprice.models.bitcoinprice.ListPrice
import com.google.gson.Gson
import java.lang.Exception
import javax.inject.Inject


abstract class BitcoinRepositoryImp @Inject constructor(
    private val services: IServicesAPI,
    private val gson: Gson
) : IBitcoinRepository {
    private var bitcoin: List<Bitcoin> = emptyList()

    override suspend fun getPrice(): Resource<ListPrice> {
        return try {
            val response = services.getPrice()
            if (response.isSuccessful) {
                bitcoin = response.body()?.data ?: emptyList()
                return Resource.Success(response.body() ?: ListPrice(emptyList()))
            } else {
                val errorBody = response.errorBody()?.string()
                val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
                return Resource.Failure(errorResponse.message)
            }
        } catch (e: Exception) {
            Resource.Failure(e.message.toString())
        }
    }
}

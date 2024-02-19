package com.eymr.bitcoinprice.data.repositories

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.data.services.IServicesAPI
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import com.eymr.bitcoinprice.models.bitcoinprice.Bitcoin
import com.eymr.bitcoinprice.models.bitcoinprice.ListPrice
import java.lang.Exception
import javax.inject.Inject

class BitcoinRepositoryImp @Inject constructor(
    private val services: IServicesAPI,
) : IBitcoinRepository {

    private var bitcoin: List<Bitcoin> = emptyList()

    override suspend fun getPrice(): Resource<ListPrice> {
        return try {
            val response = services.getPrice()
            if (response.isSuccessful) {
                bitcoin = response.body()?.data ?: emptyList()
                return Resource.Success(response.body() ?: ListPrice(emptyList()))
            } else {
                return Resource.Failure(response.message())
            }
        } catch (e: Exception) {
            Resource.Failure(e.message.toString())
        }
    }
}

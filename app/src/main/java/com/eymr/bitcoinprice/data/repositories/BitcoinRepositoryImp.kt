package com.eymr.bitcoinprice.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.core.utils.toUI
import com.eymr.bitcoinprice.data.services.IServicesAPI
import com.eymr.bitcoinprice.domain.models.bitcoinprice.BitcoinPrice
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BitcoinRepositoryImp @Inject constructor(
    private val services: IServicesAPI,
) : IBitcoinRepository {

    private val timeForRequest : Long = 30 * 1000  // 30 seconds

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getPrice(): Flow<Resource<BitcoinPrice>> = flow {
        while (true) {
            try {
                val response = services.getPrice()
                emit(Resource.Success(response.body()?.toUI() ?: BitcoinPrice()))
                // Delay for update
                kotlinx.coroutines.delay(timeForRequest)
            } catch (e: Exception) {
                emit(Resource.Failure(e.message))
                // Handle error
            }
        }
    }
}

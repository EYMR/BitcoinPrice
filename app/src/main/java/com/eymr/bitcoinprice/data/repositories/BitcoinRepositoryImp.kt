package com.eymr.bitcoinprice.data.repositories

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.data.services.IServicesAPI
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Implementation of the IBitcoinRepository interface for retrieving Bitcoin price data.
 *
 * @param services The services API interface for making network requests.
 */
class BitcoinRepositoryImp @Inject constructor(
    private val services: IServicesAPI,
) : IBitcoinRepository {

    /**
     * Time interval for requesting updated Bitcoin price data.
     */
    private val timeForRequest : Long = 30 * 1000  // 30 seconds

    /**
     * Retrieves the Bitcoin price data as a Flow of Resource<Bitcoin>.
     * The flow emits updated data at regular intervals.
     */
    override suspend fun getPrice(): Flow<Resource<Bitcoin>> = flow {
        while (true) {
            try {
                val response = services.getPrice()
                emit(Resource.Success(response.body() ?: Bitcoin()))
                // Delay for update
                kotlinx.coroutines.delay(timeForRequest)
            } catch (e: Exception) {
                emit(Resource.Failure(e.message))
                // Handle error
            }
        }
    }
}

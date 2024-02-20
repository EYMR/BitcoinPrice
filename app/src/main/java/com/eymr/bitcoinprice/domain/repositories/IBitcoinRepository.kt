package com.eymr.bitcoinprice.domain.repositories

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
import kotlinx.coroutines.flow.Flow

/**
 * Interface for defining repository operations related to Bitcoin price data.
 */
interface IBitcoinRepository {
    /**
     * Retrieves the current Bitcoin price as a Flow of Resource<Bitcoin>.
     *
     * @return A Flow emitting Resource objects containing Bitcoin price data.
     */
    suspend fun getPrice(): Flow<Resource<Bitcoin>>
}

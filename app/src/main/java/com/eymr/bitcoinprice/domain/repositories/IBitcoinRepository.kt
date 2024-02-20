package com.eymr.bitcoinprice.domain.repositories

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.domain.models.bitcoinprice.BitcoinPrice
import kotlinx.coroutines.flow.Flow

interface IBitcoinRepository {
    suspend fun getPrice() : Flow<Resource<BitcoinPrice>>

}
package com.eymr.bitcoinprice.domain.repositories

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.models.bitcoinprice.ListPrice

interface IBitcoinRepository {
    suspend fun getPrice() : Resource<ListPrice>

}
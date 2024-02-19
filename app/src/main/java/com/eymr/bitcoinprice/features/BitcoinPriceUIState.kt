package com.eymr.bitcoinprice.features

import com.eymr.bitcoinprice.models.bitcoinprice.ListPrice

data class BitcoinPriceUIState(
    val listPrice : ListPrice = ListPrice(emptyList())
)

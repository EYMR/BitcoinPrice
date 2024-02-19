package com.eymr.bitcoinprice.features

import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin

data class BitcoinPriceUIState(
    val listPrice : Bitcoin = Bitcoin()
)

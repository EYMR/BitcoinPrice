package com.eymr.bitcoinprice.domain.models.bitcoinprice

data class BitcoinPrice(
    val usdDescription : String = "",
    val eurDescription : String = "",
    val bpsDescription : String = "",
    val lastUpdate : String = "",
    val charName : String = "",
)
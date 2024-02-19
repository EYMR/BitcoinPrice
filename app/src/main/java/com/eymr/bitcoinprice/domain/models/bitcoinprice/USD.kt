package com.eymr.bitcoinprice.domain.models.bitcoinprice

data class USD(
    val code: String = "",
    val description: String = "",
    val rate: String = "",
    val rate_float: Double = 0.0,
    val symbol: String = ""
)
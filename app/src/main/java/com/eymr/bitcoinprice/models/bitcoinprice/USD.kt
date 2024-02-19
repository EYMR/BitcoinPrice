package com.eymr.bitcoinprice.models.bitcoinprice

data class USD(
    val code: String,
    val description: String,
    val rate: String,
    val rate_float: Double,
    val symbol: String
)
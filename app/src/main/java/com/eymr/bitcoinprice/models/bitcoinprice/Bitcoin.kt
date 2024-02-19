package com.eymr.bitcoinprice.models.bitcoinprice

data class Bitcoin(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)
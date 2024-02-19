package com.eymr.bitcoinprice.domain.models.bitcoinprice

data class Bitcoin(
    val bpi: Bpi = Bpi() ,
    val chartName: String = "",
    val disclaimer: String = "",
    val time: Time = Time()
)
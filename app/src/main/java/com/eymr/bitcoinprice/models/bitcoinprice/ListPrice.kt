package com.eymr.bitcoinprice.models.bitcoinprice

import com.google.gson.annotations.SerializedName

data class ListPrice(
    @SerializedName("data")
    val data: List<Bitcoin>
)
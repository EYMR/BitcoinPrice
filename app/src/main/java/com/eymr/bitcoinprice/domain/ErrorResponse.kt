package com.eymr.bitcoinprice.domain.repositories

import com.google.gson.annotations.SerializedName

//Adding this file
data class ErrorResponse(
    @SerializedName("message")
    val message: String? = ""
)

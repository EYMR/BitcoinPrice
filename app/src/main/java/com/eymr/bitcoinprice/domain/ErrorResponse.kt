package com.eymr.bitcoinprice.domain.repositories

import com.google.gson.annotations.SerializedName

//Add this file to the Repo
data class ErrorResponse(
    @SerializedName("message")
    val message: String? = ""
)

package com.eymr.bitcoinprice.domain.repositories

import com.google.gson.annotations.SerializedName

//Adding this file
/**
 * Data class representing an error response message.
 *
 * @param message The error message.
 */
data class ErrorResponse(
    @SerializedName("message")
    val message: String? = ""
)


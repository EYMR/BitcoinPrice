package com.eymr.bitcoinprice.data.services

import com.eymr.bitcoinprice.models.bitcoinprice.ListPrice
import retrofit2.Response
import retrofit2.http.GET

interface IServicesAPI {
    @GET("getPrice")
    suspend fun getPrice(): Response<ListPrice>

}
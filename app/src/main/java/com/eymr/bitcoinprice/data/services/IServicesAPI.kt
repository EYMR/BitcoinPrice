package com.eymr.bitcoinprice.data.services

import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface defining the API endpoints for retrieving Bitcoin price data.
 */
interface IServicesAPI {
    /**
     * Retrieves the current Bitcoin price.
     *
     * @return A Retrofit Response containing the Bitcoin price data.
     */
    @GET("v1/bpi/currentprice.json")
    suspend fun getPrice(): Response<Bitcoin>
}

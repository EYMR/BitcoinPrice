package com.eymr.bitcoinprice.core.di

import com.eymr.bitcoinprice.data.services.IServicesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module for providing network-related dependencies using Dagger-Hilt.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provides a singleton instance of OkHttpClient with logging interceptor.
     */
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    /**
     * Provides a singleton instance of Retrofit configured with base URL and Gson converter factory.
     *
     * @param okHttpClient The OkHttpClient instance to be used for the Retrofit instance.
     */
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.coindesk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    /**
     * Provides a singleton instance of IServicesAPI using Retrofit.
     *
     * @param retrofit The Retrofit instance to be used for creating the IServicesAPI instance.
     */
    @Singleton
    @Provides
    fun provideBitcoinService(retrofit: Retrofit): IServicesAPI =
        retrofit.create(IServicesAPI::class.java)
}

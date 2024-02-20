package com.eymr.bitcoinprice.core.di

import com.eymr.bitcoinprice.data.repositories.BitcoinRepositoryImp
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module for providing repository implementations using Dagger-Hilt.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * Binds the BitcoinRepositoryImp implementation to the IBitcoinRepository interface.
     *
     * @param repository The implementation of IBitcoinRepository to be bound.
     */
    @Singleton
    @Binds
    abstract fun bindBitcoinRepository(repository: BitcoinRepositoryImp): IBitcoinRepository
}

package com.eymr.bitcoinprice.features

import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
/**
 * Represents the UI state for displaying Bitcoin price information.
 *
 * @param listPrice The current Bitcoin price data to display.
 */
data class BitcoinPriceUIState(
    val listPrice : Bitcoin = Bitcoin()
)


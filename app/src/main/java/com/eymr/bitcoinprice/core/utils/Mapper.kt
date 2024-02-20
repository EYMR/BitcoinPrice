package com.eymr.bitcoinprice.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
import com.eymr.bitcoinprice.domain.models.bitcoinprice.BitcoinPrice

@RequiresApi(Build.VERSION_CODES.O)
fun Bitcoin.toUI() : BitcoinPrice {

    val usdDescription =  this.bpi.USD.rate + " - " + this.bpi.USD.description
    val eurDescription =  this.bpi.EUR.rate + " - " + this.bpi.EUR.description
    val gbpDescription =  this.bpi.GBP.rate + " - " + this.bpi.GBP.description
    val lastUpdate =  "Last updated on " + transformDate(this.time.updated) + " at " + transformTime(this.time.updated)

    return BitcoinPrice(
        usdDescription,
        eurDescription,
        gbpDescription,
        lastUpdate,
        this.chartName
    )

}
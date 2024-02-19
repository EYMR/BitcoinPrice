package com.eymr.bitcoinprice.domain.models.bitcoinprice

data class Bpi(
    val EUR: EUR = EUR(),
    val GBP: GBP = GBP(),
    val USD: USD = USD()
)
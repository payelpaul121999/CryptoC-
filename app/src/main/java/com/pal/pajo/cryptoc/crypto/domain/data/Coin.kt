package com.pal.pajo.cryptoc.crypto.domain.data

data class Coin(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double,
)

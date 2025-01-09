package com.pal.pajo.cryptoc.crypto.domain.networking

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceDto(
    val priceUsd: Double,
    val time: Long
)

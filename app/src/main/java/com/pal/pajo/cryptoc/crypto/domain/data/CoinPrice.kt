package com.pal.pajo.cryptoc.crypto.domain.data

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd: Double,
    val dateTime: ZonedDateTime
)

package com.pal.pajo.cryptoc.crypto.domain.networking

import com.pal.pajo.cryptoc.crypto.domain.networking.CoinPriceDto
import kotlinx.serialization.Serializable

@Serializable
data class CoinHistoryDto(
    val data: List<CoinPriceDto>
)

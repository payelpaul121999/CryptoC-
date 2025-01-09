package com.plcoding.cryptotracker.crypto.data.networking.dto

import com.pal.pajo.cryptoc.crypto.domain.networking.CoinDto
import kotlinx.serialization.Serializable

@Serializable
data class CoinsResponseDto(
    val data: List<CoinDto>
)

package com.pal.pajo.cryptoc.crypto.domain.mappers


import com.pal.pajo.cryptoc.crypto.domain.data.Coin
import com.pal.pajo.cryptoc.crypto.domain.data.CoinPrice
import com.pal.pajo.cryptoc.crypto.domain.networking.CoinDto
import com.pal.pajo.cryptoc.crypto.domain.networking.CoinPriceDto
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}
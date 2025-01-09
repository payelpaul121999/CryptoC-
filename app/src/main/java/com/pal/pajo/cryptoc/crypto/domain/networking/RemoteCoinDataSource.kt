package com.pal.pajo.cryptoc.crypto.domain.networking

import com.pal.pajo.cryptoc.core.data.networking.constructUrl
import com.pal.pajo.cryptoc.core.data.networking.safeCall
import com.pal.pajo.cryptoc.core.util.NetworkError
import com.pal.pajo.cryptoc.core.util.map
import com.pal.pajo.cryptoc.core.util.Result
import com.pal.pajo.cryptoc.crypto.domain.data.Coin
import com.pal.pajo.cryptoc.crypto.domain.data.CoinDataSource
import com.pal.pajo.cryptoc.crypto.domain.data.CoinPrice
import com.pal.pajo.cryptoc.crypto.domain.mappers.toCoin
import com.pal.pajo.cryptoc.crypto.domain.mappers.toCoinPrice
import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }
    }
}
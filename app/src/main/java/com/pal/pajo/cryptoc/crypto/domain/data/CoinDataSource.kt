package com.pal.pajo.cryptoc.crypto.domain.data

import com.pal.pajo.cryptoc.core.util.NetworkError
import com.pal.pajo.cryptoc.core.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}
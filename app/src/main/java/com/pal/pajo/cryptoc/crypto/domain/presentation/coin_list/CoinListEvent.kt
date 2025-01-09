package com.pal.pajo.cryptoc.crypto.domain.presentation.coin_list

import com.pal.pajo.cryptoc.core.util.NetworkError


sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}
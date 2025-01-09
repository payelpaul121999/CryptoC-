package com.pal.pajo.cryptoc.crypto.domain.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.pal.pajo.cryptoc.crypto.domain.presentation.coin_list.components.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)

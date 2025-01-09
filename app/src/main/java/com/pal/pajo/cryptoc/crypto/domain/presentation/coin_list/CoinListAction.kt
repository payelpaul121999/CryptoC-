package com.pal.pajo.cryptoc.crypto.domain.presentation.coin_list

import com.pal.pajo.cryptoc.crypto.domain.presentation.coin_list.components.CoinUi


sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}
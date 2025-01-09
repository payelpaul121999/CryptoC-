package com.pal.pajo.cryptoc.di

import com.pal.pajo.cryptoc.core.data.networking.HttpClientFactory
import com.pal.pajo.cryptoc.crypto.domain.data.CoinDataSource
import com.pal.pajo.cryptoc.crypto.domain.networking.RemoteCoinDataSource
import com.pal.pajo.cryptoc.crypto.domain.presentation.coin_list.CoinListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<HttpClient> { HttpClientFactory.create(CIO.create()) }
    viewModel {
        CoinListViewModel(get())
    }
    single<CoinDataSource> {
        RemoteCoinDataSource(get())
    }
    /*singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)*/
}
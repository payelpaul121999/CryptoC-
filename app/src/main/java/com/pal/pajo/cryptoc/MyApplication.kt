package com.pal.pajo.cryptoc

import android.app.Application
import com.pal.pajo.cryptoc.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()

            modules(appModule)
        }
    }
}
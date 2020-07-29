package com.sample.demolibpage3

import android.app.Application
import com.sample.commonui.di.commonuiModule
import com.sample.data.di.dataModule
import com.sample.demolibpage3.di.appModule
import com.sample.domain.di.domainModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    @ExperimentalCoroutinesApi
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(appModule + dataModule + domainModule + commonuiModule)
        }
    }
}
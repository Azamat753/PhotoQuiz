package com.lawlett.photoquiz.utils

import android.app.Application
import com.lawlett.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
startKoin {
    androidLogger()
    androidContext(this@App)
    modules(viewModelModule)
}
    }
}
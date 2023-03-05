package benny.app.strange.myapplication.android

import android.app.Application
import benny.app.strange.myapplication.android.weather.di.androidModule
import benny.app.strange.myapplication.di.common.commonModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(commonModules())
            modules(androidModule())
        }
    }
}
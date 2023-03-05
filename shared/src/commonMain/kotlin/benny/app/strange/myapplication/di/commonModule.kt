package benny.app.strange.myapplication.di

import benny.app.strange.myapplication.Greeting
import benny.app.strange.myapplication.network.NetworkClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::Greeting)
    single { NetworkClient.httpClient }
}

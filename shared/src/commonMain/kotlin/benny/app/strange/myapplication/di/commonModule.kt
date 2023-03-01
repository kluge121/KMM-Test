package benny.app.strange.myapplication.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import benny.app.strange.myapplication.Greeting
import benny.app.strange.myapplication.Platform

val commonModule = module {
    singleOf(::Greeting)
}

val platformModule = module {
}

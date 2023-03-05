package benny.app.strange.myapplication.di

import benny.app.strange.myapplication.repository.TodayWeatherRepository
import benny.app.strange.myapplication.source.WeatherRemoteSource
import benny.app.strange.myapplication.usecase.GetTodayT1HUseCase
import org.koin.dsl.module

val weatherModule = module {
    factory { WeatherRemoteSource(get()) }
    factory { TodayWeatherRepository(get()) }
    factory { GetTodayT1HUseCase(get()) }
}
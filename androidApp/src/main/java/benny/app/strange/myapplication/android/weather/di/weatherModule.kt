package benny.app.strange.myapplication.android.weather.di

import benny.app.strange.myapplication.android.weather.today.TodayWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {
    viewModel { TodayWeatherViewModel(get()) }
}
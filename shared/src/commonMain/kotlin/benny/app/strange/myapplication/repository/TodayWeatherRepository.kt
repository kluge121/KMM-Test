package benny.app.strange.myapplication.repository

import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.model.response.TodayWeatherResponse
import benny.app.strange.myapplication.source.WeatherRemoteSource

class TodayWeatherRepository(
    private val source: WeatherRemoteSource
) {
    suspend fun getTodayWeatherInfo(request: TodayWeatherRequest): List<TodayWeatherResponse.Response.Body.Items.Item> {
        return source.getTodayWeather(request).response.body.items.item

    }
}
package benny.app.strange.myapplication.source

import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.model.response.TodayWeatherResponse
import benny.app.strange.myapplication.network.NetworkClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import io.ktor.utils.io.*

class WeatherRemoteSource {

    private val client = NetworkClient.httpClient

    @Throws(Exception::class)
    suspend fun getTodayWeather(request: TodayWeatherRequest): TodayWeatherResponse {
        return client.get {
            headers {
                append("content-type", "application/json")
            }
            url {
                url.host = "apis.data.go.kr"
                url.pathSegments = listOf("1360000", "VilageFcstInfoService_2.0", "getUltraSrtNcst")
                url.parameters.apply {
                    append("serviceKey", request.serviceKey)
                    append("pageNo", request.pageNo.toString())
                    append("numOfRows", request.numOfRows.toString())
                    append("dataType", request.dataType)
                    append("base_date", request.baseDate)
                    append("base_time", request.baseTime)
                    append("nx", request.nx)
                    append("ny", request.ny)
                }
            }
        }.body()
    }
}
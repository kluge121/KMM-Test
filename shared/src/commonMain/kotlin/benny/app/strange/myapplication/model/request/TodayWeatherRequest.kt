package benny.app.strange.myapplication.model.request

data class TodayWeatherRequest(
    val serviceKey: String,
    val pageNo: Int,
    val numOfRows: Int = 1000,
    val dataType: String = "JSON",
    val baseDate: String,
    val baseTime: String,
    val nx: String,
    val ny: String
)
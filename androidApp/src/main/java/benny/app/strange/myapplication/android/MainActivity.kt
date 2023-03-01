package benny.app.strange.myapplication.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import benny.app.strange.myapplication.Greeting
import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.source.WeatherRemoteSource
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            WeatherRemoteSource().getTodayWeather(
                TodayWeatherRequest(
                    serviceKey = BuildConfig.API_KEY,
                    pageNo = 1,
                    baseDate = "20230301",
                    baseTime = "0600",
                    nx= "55",
                    ny = "127"
                )
            ).let {
                println(it)
            }
        }
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}

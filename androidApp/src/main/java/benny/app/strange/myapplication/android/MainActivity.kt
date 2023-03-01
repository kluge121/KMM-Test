package benny.app.strange.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import benny.app.strange.myapplication.Greeting
import benny.app.strange.myapplication.android.BuildConfig.API_KEY
import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.source.WeatherRemoteSource
import org.koin.android.ext.android.inject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {

    private val greeting: Greeting by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            WeatherRemoteSource().getTodayWeather(
                TodayWeatherRequest(
                    serviceKey = API_KEY,
                    pageNo = 1,
                    baseDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE),
                    baseTime = "0600",
                    nx = "55",
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
                    GreetingView(greeting.greet())
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

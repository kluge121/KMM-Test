package benny.app.strange.myapplication.android.weather.today

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import benny.app.strange.myapplication.android.BuildConfig
import benny.app.strange.myapplication.android.MyApplicationTheme
import benny.app.strange.myapplication.android.R
import benny.app.strange.myapplication.model.entity.TodayWeatherEntity
import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.source.WeatherRemoteSource
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter.BASIC_ISO_DATE
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE

class TodayWeatherActivity : ComponentActivity() {

    private val test: WeatherRemoteSource by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(viewModel: TodayWeatherViewModel = koinViewModel()) {
    LaunchedEffect(key1 = Unit) {
        TodayWeatherRequest(
            serviceKey = BuildConfig.API_KEY,
            pageNo = 1,
            baseDate = LocalDate.now().format(BASIC_ISO_DATE),
            baseTime = "0600",
            nx = "55",
            ny = "127"
        ).let(viewModel::getTodayTemperature)
    }


    val uiState by viewModel.uiState.collectAsState()

    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillHeight,
        painter = painterResource(id = R.drawable.bg_default),
        contentDescription = null
    )
    uiState.firstOrNull()?.let {
        TodayWeatherItemScreen(it)
    }

}

@Composable
private fun TodayWeatherItemScreen(todayWeatherEntity: TodayWeatherEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.35f)
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp),
            painter = painterResource(id = R.drawable.ic_default), contentDescription = null
        )

        todayWeatherEntity.apply {
            Text(
                modifier = Modifier,
                color = Color.LightGray,
                text = obsrValue,
                fontSize = 64.sp
            )
        }

    }

}



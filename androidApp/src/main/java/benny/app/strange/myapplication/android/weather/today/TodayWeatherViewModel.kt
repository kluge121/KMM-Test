package benny.app.strange.myapplication.android.weather.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import benny.app.strange.myapplication.model.entity.TodayWeatherEntity
import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.usecase.GetTodayT1HUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodayWeatherViewModel(
    private val getTodayT1H: GetTodayT1HUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<TodayWeatherEntity>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getTodayTemperature(request: TodayWeatherRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                getTodayT1H(request)
            }.onSuccess {
                _uiState.emit(it)
            }.onFailure {
                _uiState.emit(emptyList())
            }
        }
    }
}
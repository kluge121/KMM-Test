package benny.app.strange.myapplication.usecase

import benny.app.strange.myapplication.model.entity.TodayWeatherEntity
import benny.app.strange.myapplication.model.request.TodayWeatherRequest
import benny.app.strange.myapplication.repository.TodayWeatherRepository

class GetTodayT1HUseCase(
    private val repository: TodayWeatherRepository
) {
    @Throws(Exception::class)
    suspend operator fun invoke(request: TodayWeatherRequest): List<TodayWeatherEntity> {
        return repository.getTodayWeatherInfo(request)
            .filter { it.category == "T1H" }
            .map {
                it.toEntity()
            }
    }

}
package benny.app.strange.myapplication.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.auth.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal object NetworkClient {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        engine {
            this.
        }
    }
}


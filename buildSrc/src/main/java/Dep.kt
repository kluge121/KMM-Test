object Dep {
    private object Version {
        const val ktor = "2.2.4"
        const val koin = "3.3.3"
    }

    /**
     * Common Libraries
     */
    object Common {

        object Koin {
            const val core = "io.insert-koin:koin-core:${Dep.Version.koin}"
            const val test = "io.insert-koin:koin-test:${Dep.Version.koin}"
        }

        object Ktor {
            const val core = "io.ktor:ktor-client-core:${Dep.Version.ktor}"
            const val negotiation = "io.ktor:ktor-client-content-negotiation:${Dep.Version.ktor}"
            const val serialization = "io.ktor:ktor-serialization-kotlinx-json:${Dep.Version.ktor}"
            const val logging = "io.ktor:ktor-client-logging:${Dep.Version.ktor}"
        }

        object Coroutines {
            private const val Version = "1.6.4"
            const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$Version"
        }

        object DateTime {
            private const val Version = "0.4.0"
            const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:$Version"
        }
    }

    /**
     * Androi Libraries
     */
    object Android {
        object Koin {
            const val android = "io.insert-koin:koin-android:${Dep.Version.koin}"
            const val compose = "io.insert-koin:koin-androidx-compose:3.4.1"
        }

        object Ktor {
            const val android = "io.ktor:ktor-client-android:${Dep.Version.ktor}"
        }
    }

    /**
     * IOS Libraries
     */
    object IOS {
        object Ktor {
            const val darwin = "io.ktor:ktor-client-darwin:${Dep.Version.ktor}"
        }
    }
}
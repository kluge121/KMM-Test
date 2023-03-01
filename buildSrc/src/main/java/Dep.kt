import Dep.Version.ktorVersion

object Dep {
    private object Version {
        const val ktorVersion = "2.2.1"
    }

    object Common {

        object Ktor {
            const val core = "io.ktor:ktor-client-core:$ktorVersion"
            const val negotiation = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
            const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
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

    object Android {
        object Ktor {
            const val android = "io.ktor:ktor-client-android:$ktorVersion"
        }
    }

    object Ios {
        object Ktor {
            const val darwin = "io.ktor:ktor-client-darwin:$ktorVersion"
        }
    }
}
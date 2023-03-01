package benny.app.strange.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
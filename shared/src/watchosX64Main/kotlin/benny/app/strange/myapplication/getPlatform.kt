package benny.app.strange.myapplication

class WatchPlatform: Platform {
    override val name: String = "지구 밖에서온 Watch X64 플랫폼 "
}

actual fun getPlatform(): Platform = WatchPlatform()
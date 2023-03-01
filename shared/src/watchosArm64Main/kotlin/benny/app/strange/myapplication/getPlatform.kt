package benny.app.strange.myapplication

class WatchOSArm64Platform: Platform {
    override val name: String = "지구 밖에서 온 워치 Arm64"
}

actual fun getPlatform(): Platform = WatchOSArm64Platform()
package benny.app.strange.myapplication

class WatchOSArm32Platform: Platform {
    override val name: String = "지구 밖에서 온 워치 Arm32"
}

actual fun getPlatform(): Platform = WatchOSArm32Platform()
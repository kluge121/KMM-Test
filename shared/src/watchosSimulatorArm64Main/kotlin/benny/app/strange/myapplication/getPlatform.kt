package benny.app.strange.myapplication

class WatchOSSimulatorArm64Platform: Platform {
    override val name: String = "지구 밖에서 온 워치 Arm64 Simulator"
}

actual fun getPlatform(): Platform = WatchOSSimulatorArm64Platform()
package benny.app.strange.myapplication

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Welcome KMM! from. ${platform.name}"
    }
}
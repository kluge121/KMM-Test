plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.10"
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        watchosArm32(),
        watchosArm64(),
        watchosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {

        // for shared
        val commonMain by getting {
            // common dependencies, 공용으로 사용할 라이브러리 추가.
            dependencies {
                implementation(Dep.Common.Koin.core)
                implementation(Dep.Common.Coroutines.coroutine)
                implementation(Dep.Common.Ktor.core)
                implementation(Dep.Common.Ktor.negotiation)
                implementation(Dep.Common.Ktor.serialization)
                implementation(Dep.Common.DateTime.dateTime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        // for android
        val androidMain by getting {
            dependencies {
                implementation(Dep.Android.Ktor.android)
            }
        }
        val androidUnitTest by getting


        // for ios
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(Dep.IOS.Ktor.darwin)
            }
        }


        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }

        // for watch
        val watchosArm32Main by getting
        val watchosArm64Main by getting
        val watchosSimulatorArm64Main by getting
        val watchosMain by creating {
            dependsOn(commonMain)
            watchosArm32Main.dependsOn(this)
            watchosArm64Main.dependsOn(this)
            watchosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(Dep.IOS.Ktor.darwin)
            }
        }
    }
}

android {
    namespace = "benny.app.strange.myapplication"
    compileSdk = 33
    defaultConfig {
        minSdk = 28
        targetSdk = 33
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}

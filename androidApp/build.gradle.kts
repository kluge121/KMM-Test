import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "benny.app.strange.myapplication.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "benny.app.strange.myapplication.android"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        val localProperties = gradleLocalProperties(rootDir)

        buildConfigField(
            "String",
            "API_KEY",
            localProperties.getProperty("weather.api.key")
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "DebugProbesKt.bin"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.3")
    implementation("androidx.compose.ui:ui-tooling:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.core:core-ktx:1.9.0")

    implementation(Dep.Common.Koin.core)
    implementation(Dep.Android.Koin.android)
    implementation(Dep.Android.Koin.compose)

}

import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val apikeyPropertiesFile = rootProject.file("api_key.properties")
val apikeyProperties = Properties()
apikeyProperties.load(FileInputStream(apikeyPropertiesFile))

android {
    compileSdkVersion(App.compileSdk)
    buildToolsVersion(App.buildToolsVersion)

    defaultConfig {
        minSdkVersion(App.minSdk)
        targetSdkVersion(App.targetSdk)

        versionCode(App.versionCode)
        versionName(App.versionName)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", (apikeyProperties["API_KEY"] as? String) ?: "Insert your Api Key")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    with(Libs.Kotlin){
        implementation(kotlin)
        implementation(coroutine)
        implementation(coroutineAndroid)
    }

    with(Libs.Android) {
        implementation(core)
    }

    with(Libs.Android.JetPack) {
        implementation(hilt_android)
        kapt(hilt_compiler)

        implementation(room)
        implementation(roomKtx)
        kapt(room_compiler)
    }

    with(Libs.Test){
        testImplementation(jUnit)
        androidTestImplementation(jUntExt)
        androidTestImplementation(espresso)
    }

    with(Libs.Network) {
        implementation(retrofit)
        implementation(gson)
        implementation(okhttp)
        implementation(interceptor)
    }
    
}
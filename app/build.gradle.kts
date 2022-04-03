plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":feature"))
    implementation(project(":domain"))
    implementation(project(":shared"))

    with(Libs.Kotlin) {
        implementation(kotlin)
        implementation(coroutine)
        implementation(coroutineAndroid)
    }

    with(Libs.Android) {
        implementation(core)
        implementation(appCompat)
    }

    with(Libs.Android.JetPack) {
        implementation(hilt_android)
        kapt(hilt_compiler)
    }

    with(Libs.Network) {
        implementation(retrofit)
        implementation(gson)
        implementation(okhttp)
        implementation(interceptor)
    }
}
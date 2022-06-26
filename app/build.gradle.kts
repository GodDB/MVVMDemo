plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {

    buildFeatures {
        //TODO(22/6/26) compose 마이그레이션 완료 후 제거 예정
        dataBinding = true

        compose = true
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
        implementation(compose_runtime)
    }

    with(Libs.Network) {
        implementation(retrofit)
        implementation(gson)
        implementation(okhttp)
        implementation(interceptor)
    }
}
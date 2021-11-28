
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.library")
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
    implementation(project(mapOf("path" to ":shared")))
    implementation(project(mapOf("path" to ":domain")))

    with(Libs.Kotlin){
        implementation(kotlin)
        implementation(coroutine)
        implementation(coroutineAndroid)
    }

    with(Libs.Android) {
        implementation(core)
        implementation(appCompat)
        implementation(material)
        implementation(constraintLayout)
        implementation(lifecycle)
    }

    with(Libs.Android.JetPack) {
        implementation(viewModel)
        implementation(liveData)
        implementation(hilt_android)
        kapt(hilt_compiler)
        kapt(viewModel_hilt)
        implementation(activityKtx)

        implementation(room)
        implementation(roomKtx)
        kapt(room_compiler)
    }

    with(Libs.Test){
        testImplementation(junit)
        androidTestImplementation(androidJunit)
        androidTestImplementation(androidJunitExt)
        androidTestImplementation(espresso)
        testImplementation(mockitoKotlin)
        testImplementation(coroutineTest)
        testImplementation(androidTest)
    }

    with(Libs.Network) {
        implementation(retrofit)
        implementation(gson)
        implementation(okhttp)
        implementation(interceptor)
    }

    with(Libs.Glide) {
        implementation(glide)
        kapt(glide_compiler)
    }

}
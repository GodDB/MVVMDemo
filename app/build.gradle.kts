import java.io.FileInputStream
import java.util.*

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

    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":feature")))
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":shared")))

    with(Libs.Kotlin) {
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
        // For Robolectric tests.
        testImplementation(hilt_test)
        kaptTest(hilt_compiler)
        // For instrumented tests.
        androidTestImplementation(hilt_test)
        kaptAndroidTest(hilt_compiler)
        kapt(viewModel_hilt)

        implementation(activityKtx)

        implementation(room)
        implementation(roomKtx)
        kapt(room_compiler)
    }

    with(Libs.Test) {
        testImplementation(junit)
        androidTestImplementation(androidJunit)
        androidTestImplementation(androidJunitExt)
        androidTestImplementation(espresso)
        testImplementation(mockitoKotlin)
        testImplementation(coroutineTest)
        testImplementation(androidTest)
        testImplementation(kotlinTest)
        testImplementation(kotlinJUnit)
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
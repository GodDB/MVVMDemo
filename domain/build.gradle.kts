import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {

    implementation(project(mapOf("path" to ":shared")))

    with(Libs.Kotlin) {
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
        // For Robolectric tests.
        testImplementation(hilt_test)
        kaptTest(hilt_compiler)
        // For instrumented tests.
        androidTestImplementation(hilt_test)
        kaptAndroidTest(hilt_compiler)
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

}
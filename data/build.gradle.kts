
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
    defaultConfig {
        buildConfigField("String", "API_KEY", (apikeyProperties["API_KEY"] as? String) ?: "Insert your Api Key")
    }
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":shared")))

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
    
}
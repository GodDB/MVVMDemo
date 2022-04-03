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
    implementation(project(":shared"))
    implementation(project(":domain"))

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
        implementation(activityKtx)
    }

    with(Libs.Test) {
        androidTestImplementation(androidJunit)
        androidTestImplementation(androidJunitExt)
        androidTestImplementation(espresso)
        testImplementation(kotlinJUnit)
        testImplementation(mockitoKotlin)
        testImplementation(coroutineTest)
        testImplementation(androidTest)
    }

    with(Libs.Glide) {
        implementation(glide)
        kapt(glide_compiler)
    }
}
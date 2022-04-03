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
        implementation(recyclerView)
        implementation(lifecycle_runtime_ktx)
    }

    with(Libs.Android.JetPack) {
        implementation(viewModel)
        implementation(hilt_android)
        kapt(hilt_compiler)
        implementation(activityKtx)
        implementation(fragmentKtx)
        implementation(navigation_fragment_ktx)
        implementation(navigation_view_ktx)
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
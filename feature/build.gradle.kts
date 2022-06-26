plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {

    buildFeatures {
        //TODO(22/6/26) compose 마이그레이션 완료 후 제거 예정
        dataBinding = true

        compose = true
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

        // compose
        implementation(compose_activity)
        implementation(compose_viewModel)
        implementation(compose_animation)
        implementation(compose_material)
        implementation(compose_ui_tooling)
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
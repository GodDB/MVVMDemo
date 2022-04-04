object App {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val appId = "com.example.mvvmdemo"
    const val buildToolsVersion = "30.0.3"
}

object Versions {

    const val gradle = "7.0.2"

    object Kotlin {
        const val kotlin = "1.6.0"
        const val coroutineTest = "1.6.0"
        const val coroutineAndroid = "1.5.0"
    }

    object Android {
        const val core = "1.7.0"
        const val appCompat = "1.4.0"
        const val material = "1.5.0"
        const val constraintLayout = "2.1.3"
        const val lifecycle = "2.4.1"
        const val activityKtx = "1.4.0"
        const val fragmentKtx = "1.4.0"
        const val recyclerView = "1.2.0"

        const val hilt = "2.37"

        const val room = "2.4.0"
        const val navigation = "2.4.1"
    }

    object Network {
        const val retrofit = "2.9.0"
        const val okHttp = "4.9.1"
    }

    object Glide {
        const val glide = "4.12.0"
        const val glide_compiler = "4.11.0"
    }

}

object Libs {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    object Kotlin {
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlin}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlin}"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.kotlin}"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.coroutineAndroid}"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val androidJunit = "androidx.test.ext:junit:1.1.3"
        const val androidJunitExt = "androidx.test.ext:junit-ktx:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:3.2.0"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.Kotlin.kotlin}"
        const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.Kotlin.kotlin}"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlin.coroutineTest}"
        const val androidTest = "androidx.arch.core:core-testing:2.1.0"
    }

    object Android {
        const val core = "androidx.core:core-ktx:${Versions.Android.core}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Android.appCompat}"
        const val material = "com.google.android.material:material:${Versions.Android.material}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}"
        const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.lifecycle}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Android.recyclerView}"


        object JetPack {
            const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Android.hilt}"
            const val hilt_android = "com.google.dagger:hilt-android:${Versions.Android.hilt}"
            const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.Android.hilt}"
            const val hilt_test = "com.google.dagger:hilt-android-testing:${Versions.Android.hilt}"

            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.lifecycle}"
            const val activityKtx = "androidx.activity:activity-ktx:${Versions.Android.activityKtx}"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.Android.fragmentKtx}"

            const val room = "androidx.room:room-runtime:${Versions.Android.room}"
            const val room_compiler = "androidx.room:room-compiler:${Versions.Android.room}"
            const val roomKtx = "androidx.room:room-ktx:${Versions.Android.room}"

            const val navigation_safe_args_plugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Android.navigation}"
            const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.Android.navigation}"
            const val navigation_view_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.Android.navigation}"
        }
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.Network.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Network.okHttp}"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Network.okHttp}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Glide.glide}"
        const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.Glide.glide_compiler}"
    }

    const val inject = "javax.inject:javax.inject:1"
}
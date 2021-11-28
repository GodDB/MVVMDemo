plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {

    with(Libs.Kotlin){
        implementation(kotlin)
        implementation(coroutine)
        implementation(coroutineAndroid)
    }

    implementation(Libs.inject)

    with(Libs.Android) {
        implementation(core)
    }
}
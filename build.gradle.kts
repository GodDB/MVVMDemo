import java.net.URI

// Top-level build file where you can add configuration options gradle to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Libs.gradle)
        classpath(Libs.Kotlin.plugin)
        classpath(Libs.Android.JetPack.hilt_plugin)
        classpath(Libs.Android.JetPack.navigation_safe_args_plugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = URI.create("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    applyCommonGradle(this)
}

// region common gradle
fun applyCommonGradle(project: Project) {
    project.plugins.whenPluginAdded {
        when (this) {
            is com.android.build.gradle.internal.plugins.AppPlugin -> {
                appGradle(project)
            }
            is com.android.build.gradle.internal.plugins.LibraryPlugin -> {
                libGradle(project)
            }
        }
    }
}

fun appGradle(project: Project) {

    val subProject = project.extensions.getByType<com.android.build.gradle.AppExtension>()
    with(subProject) {
        baseGradle()
        defaultConfig {
            applicationId = App.appId
        }

        buildTypes {
            getByName("debug") {
                isShrinkResources = false
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

            getByName("release") {
                isShrinkResources = true
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}

fun libGradle(project: Project) {
    val libProject = project.extensions.getByType<com.android.build.gradle.LibraryExtension>()
    with(libProject) {
        baseGradle()
        defaultConfig {
            consumerProguardFile("consumer-rules.pro")
        }

        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}

fun com.android.build.gradle.BaseExtension.baseGradle() {

    compileSdkVersion(App.compileSdk)
    buildToolsVersion(App.buildToolsVersion)

    defaultConfig {
        targetSdk = App.targetSdk
        minSdk = App.minSdk
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

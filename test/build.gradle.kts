
plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    with(Libs.Test) {
        implementation(junit)
        api(coroutineTest)
        api(mockitoKotlin)
    }
}
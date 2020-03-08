
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildTools)


    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("debug").java.srcDirs("src/debug/kotlin")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlin)

    implementation(project(path = ":retrofit_network"))
    implementation(project(path = ":data_and_interface_android"))
    implementation(project(path = ":glide_image_loader"))

    implementation(Libraries.dagger)
    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerSupport)
    kapt(Libraries.daggerProcessor)
    kapt(Libraries.daggerCompile)
    implementation(AndroidLibraries.androidxLifecycleExtension)
    implementation(AndroidLibraries.androidxLifecycleViewModel)
    implementation(AndroidLibraries.androidxAppcompat)
    implementation(Libraries.retrofit)
    implementation(Libraries.moshi)
    implementation(Libraries.okhttp)

    testImplementation(TestLibraries.junit)
    androidTestImplementation(AndroidTestLibraries.runner)
    androidTestImplementation(AndroidTestLibraries.espressoCore)
}

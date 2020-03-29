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

    implementation(project(":domain_interface"))
    implementation(project(":presentation_interface"))
    implementation(project(":di"))

    implementation(Libraries.daggerSupport)
    implementation(Libraries.coroutines)
    implementation(AndroidLibraries.androidxAppcompat)
    implementation(AndroidLibraries.androidRecyclerView)
    implementation(AndroidLibraries.androidxLifecycleExtension)
    implementation(AndroidLibraries.androidxLifecycleViewModel)

    testImplementation(TestLibraries.junit)
    androidTestImplementation(AndroidTestLibraries.runner)
    androidTestImplementation(AndroidTestLibraries.espressoCore)
}

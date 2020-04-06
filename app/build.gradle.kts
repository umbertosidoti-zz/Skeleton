import java.io.FileInputStream
import java.util.*


plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

val prop = Properties()
prop.load(FileInputStream(project.file("apikey.properties")))
val unsplashKey: String = prop.getProperty("UNSPLASH_CLIENT_KEY")

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildTools)
    defaultConfig {
        applicationId = "com.umbo.skeleton"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "com.umbo.skeleton.di.MockTestRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            buildConfigField("String", "unsplashKey", unsplashKey)
        }
        getByName("debug") {
            buildConfigField("String", "unsplashKey", unsplashKey)
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("debug").java.srcDirs("src/debug/kotlin")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":presentation_interface"))
    implementation(project(":presentation"))
    implementation(project(":domain_interface"))
    implementation(project(":domain"))
    implementation(project(":network_interface"))
    implementation(project(":network"))
    implementation(project(":di_core"))
    implementation(project(":glide_image_loader"))

    implementation(Libraries.kotlin)
    implementation(Libraries.coroutines)

    implementation(AndroidLibraries.androidxConstraintlayout)
    implementation(AndroidLibraries.androidxNavigationFragment)
    implementation(AndroidLibraries.androidxNavigationUi)
    implementation(Libraries.dagger)
    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerSupport)
    implementation(Libraries.okhttp)
    implementation(Libraries.retrofit)
    implementation(Libraries.moshi)
    implementation(Libraries.glide)

    kapt(Libraries.daggerProcessor)
    kapt(Libraries.daggerCompile)

    kapt(Libraries.glideCompiler)

    implementation(AndroidTestLibraries.espressoIdling)

    androidTestImplementation(AndroidTestLibraries.runner)
    androidTestImplementation(TestLibraries.junit)
    androidTestImplementation(AndroidTestLibraries.espressoCore)
    androidTestImplementation(AndroidTestLibraries.testRules)
    androidTestImplementation(TestLibraries.kakao)
    androidTestImplementation(AndroidTestLibraries.espressoContrib) {
        exclude(group = "com.android.support", module = "appcompat")
        exclude(group = "com.android.support", module = "support-v4")
        exclude(module = "recyclerview-v7")
    }
}
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

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
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":data_and_interface"))
    implementation(project(":data_and_interface_android"))
    implementation(project(":domain"))
    implementation(project(":di"))

    implementation(Libraries.kotlin)
    implementation(Libraries.coroutines)

    implementation(AndroidLibraries.androidxAppcompat)
    implementation(AndroidLibraries.androidxCore)
    implementation(AndroidLibraries.androidxConstraintlayout)
    implementation(AndroidLibraries.androidxLegacy)
    implementation(AndroidLibraries.androidxLifecycleExtension)
    implementation(AndroidLibraries.androidxLifecycleViewModel)
    implementation(AndroidLibraries.androidxNavigationFragment)
    implementation(AndroidLibraries.androidxNavigationUi)
    implementation(Libraries.dagger)
    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerSupport)
    kapt(Libraries.daggerProcessor)
    kapt(Libraries.daggerCompile)

    implementation(AndroidTestLibraries.espressoIdling)
    testImplementation(AndroidTestLibraries.archCore)
    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.mockito)
    testImplementation(TestLibraries.coroutinesTest)

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
object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
    const val buildTools = "29.0.2"
}

object AndroidLibraries {
    private object Versions {
        const val androidxAppcompat = "1.1.0"
        const val androidxCore = "1.2.0"
        const val androidxConstraintlayout = "1.1.3"
        const val androidxLegacy = "1.0.0"
        const val androidxLifecycle = "2.2.0"
        const val androidxNavigation = "2.2.0"
    }

    val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    val androidxConstraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintlayout}"
    val androidxLegacy = "androidx.legacy:legacy-support-v4:${Versions.androidxLegacy}"
    val androidxLifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
    val androidxLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    val androidxNavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
    val androidxNavigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
}

object Libraries {
    private object Versions {
        const val dagger = "2.24"
    }

    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerCompile = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}


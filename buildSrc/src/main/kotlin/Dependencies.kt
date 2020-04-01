object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
    const val buildTools = "29.0.2"
    const val kotlin = "1.3.41"
}

object AndroidLibraries {
    private object Versions {
        const val androidxAppcompat = "1.1.0"
        const val androidxCore = "1.2.0"
        const val androidxConstraintlayout = "1.1.3"
        const val androidxLegacy = "1.0.0"
        const val androidxLifecycle = "2.2.0"
        const val androidxNavigation = "2.2.0"
        const val androidRecyclerView = "1.0.0"
    }

    val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    val androidxConstraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintlayout}"
    val androidxLegacy = "androidx.legacy:legacy-support-v4:${Versions.androidxLegacy}"
    val androidxLifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
    val androidxLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    val androidxNavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigation}"
    val androidxNavigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigation}"
    val androidRecyclerView = "androidx.recyclerview:recyclerview:${Versions.androidRecyclerView}"
}

object Libraries {
    private object Versions {
        const val dagger = "2.24"
        const val coroutines = "1.3.0"
        const val retrofit = "2.6.1"
        const val moshi = "2.6.1"
        const val okhttp = "4.3.1"
        const val glide = "4.9.0"
    }

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${AndroidSdk.kotlin}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerCompile = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object AndroidTestLibraries {
    private object Version {
        const val espressoIdling = "3.2.0"
        const val archCore = "1.1.1"
        const val extJunit = "1.1.1"
        const val runner = "1.2.0"
        const val espressoCore = "3.2.0"
        const val testRules = "1.0.2"
        const val espressoContrib = "2.0"
    }

    val espressoIdling = "androidx.test.espresso:espresso-idling-resource:${Version.espressoIdling}"
    val archCore = "android.arch.core:core-testing:${Version.archCore}"
    val runner =  "androidx.test:runner:${Version.runner}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    val testRules = "com.android.support.test:rules:${Version.testRules}"
    val espressoContrib = "com.android.support.test.espresso:espresso-contrib:${Version.espressoContrib}"
}

object TestLibraries {
    private object Version {
        const val junit = "4.12"
        const val mockito = "2.2.0"
        const val coroutinesTest = "1.3.3"
        const val kakao =  "2.2.0"
    }

    val junit = "junit:junit:${Version.junit}"
    val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockito}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutinesTest}"
    val kakao =  "com.agoda.kakao:kakao:${Version.kakao}"

}


// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.41")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks {
    val clear by registering(Delete::class) {
        delete(buildDir)
    }
}

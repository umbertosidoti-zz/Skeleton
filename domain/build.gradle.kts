plugins {
    id("kotlin")
    id("com.umbo.kotlincoverage")
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlin)

    compile (project(path = ":data_and_interface"))

    implementation(Libraries.coroutines)

    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.mockito)

}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}


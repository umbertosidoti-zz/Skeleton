package com.umbo.skeleton

import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

@Suppress("UnsafeCast", "ThrowRuntimeException", "NestedBlockDepth")
object CodeCoverageOptions {

    private const val FULL_COVERAGE_REPORT_TASK = "fullCoverageReport"
    private const val REPORT_DESCRIPTION = "Generate Jacoco coverage reports aggregated from all project"


    fun Project.applyAndroidCodeCoverageOptions() = this.run {
        afterEvaluate {
            configureAndroid("","","","")
        }

    }

    private fun Project.configureAndroid(
        testTaskName: String,
        javaClassesSubfolder: String,
        kotlinClassesSubfolder: String,
        executionDataPath: String
    ): JacocoReport {

        plugins.apply("jacoco")
        configure<JacocoPluginExtension> {
            toolVersion = "0.8.5"
        }

        tasks.whenTaskAdded {
            extensions.findByType(JacocoTaskExtension::class.java)?.let {
                extensions.getByType(JacocoTaskExtension::class.java).apply {
                    isIncludeNoLocationClasses = true
                }
            }
        }

        return tasks.create("jacocoTestReport", JacocoReport::class) {
            dependsOn(testTaskName)

            group = "Reporting"
            description = "Generate Jacoco coverage reports after running tests."

            reports {
                xml.isEnabled = true
                xml.destination = file("$buildDir/reports/jacoco/jacoco.xml")

                html.isEnabled = true
                html.destination = file("$buildDir/reports/jacoco")
            }

            val debugTree = fileTree(javaClassesSubfolder) { exclude(emptyList()) }
            val kotlinDebugTree = fileTree(kotlinClassesSubfolder) { exclude(emptyList()) }
            val unified = files(debugTree, kotlinDebugTree)

            classDirectories.setFrom(unified)

            sourceDirectories.setFrom(files("${projectDir}/src/main/java", "${projectDir}/src/main/kotlin"))
            additionalSourceDirs.setFrom(files("${projectDir}/src/main/java", "${projectDir}/src/main/kotlin"))

            executionData.setFrom(files(executionDataPath))

            doFirst {
                unified.files.forEach { file ->
                    if (file.name.contains("$$")) {
                        file.renameTo(file(file.path.replace("$$", "$")))
                    }
                }
            }
        }
    }
}

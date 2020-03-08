@file:Suppress("UnstableApiUsage")

package com.umbo.skeleton

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.*
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

@Suppress("UnsafeCast", "ThrowRuntimeException", "NestedBlockDepth")
object CoverageUtils {

    private const val FULL_COVERAGE_REPORT_TASK = "fullJacocoCoverageReport"
    private const val REPORT_DESCRIPTION = "Generate Jacoco coverage reports aggregated from all project"

    fun Project.applyAndroidCodeCoverageOptions() = this.run {
        afterEvaluate {
            println("Jacoco: Add to ${project.name} module jacoco(android) coverage")
            val task = configureAndroid()
            addToRoot(project, FULL_COVERAGE_REPORT_TASK, task, REPORT_DESCRIPTION)
        }

    }

    fun Project.applyKotlinCodeCoverageOptions() = this.run {
        afterEvaluate {
            println("Jacoco: Add to ${project.name} module jacoco(kotlin) coverage")
            val task = configureKotlin()
            addToRoot(project, FULL_COVERAGE_REPORT_TASK, task, REPORT_DESCRIPTION)
        }

    }

    private fun Project.configureKotlin(): JacocoReport {
        plugins.apply("jacoco")
        configure<JacocoPluginExtension> {
            toolVersion = "0.8.5"
        }

        return tasks.create("moduleJacocoCoverageReport", JacocoReport::class) {
            dependsOn("test")

            group = "Reporting"
            description = "Generate Jacoco coverage reports after running tests."

            reports {
                xml.isEnabled = true
                xml.destination = file("${project.buildDir}/reports/jacoco/jacoco.xml")

                html.isEnabled = true
                html.destination = file("${project.buildDir}/reports/jacoco")
            }

           // val javaDebugTree = fileTree("${project.buildDir}/intermediates/javac/debug") { exclude(emptyList()) }
            val kotlinDebugTree = fileTree("${project.buildDir}/classes/kotlin/main") { exclude(emptyList()) }
            val unifiedTree = files(kotlinDebugTree)

            classDirectories.setFrom(unifiedTree)

            sourceDirectories.setFrom(files("$projectDir/src/main/java", "$projectDir/src/main/kotlin"))
            additionalSourceDirs.setFrom(files("$projectDir/src/main/java", "$projectDir/src/main/kotlin"))

            executionData.setFrom(files("${project.buildDir}/jacoco/test.exec"))

            doFirst {
                unifiedTree.files.forEach { file ->
                    if (file.name.contains("$$")) {
                        file.renameTo(file(file.path.replace("$$", "$")))
                    }
                }
            }
        }
    }


    private fun Project.configureAndroid(): JacocoReport {

        plugins.apply("jacoco")
        configure<JacocoPluginExtension> {
            toolVersion = "0.8.5"
        }

        return tasks.create("moduleJacocoCoverageReport", JacocoReport::class) {
            dependsOn("testDebugUnitTest")

            group = "Reporting"
            description = "Generate Jacoco coverage reports after running tests."

            reports {
                xml.isEnabled = true
                xml.destination = file("${project.buildDir}/reports/jacoco/jacoco.xml")

                html.isEnabled = true
                html.destination = file("${project.buildDir}/reports/jacoco")
            }

            val javaDebugTree = fileTree("${project.buildDir}/intermediates/javac/debug") { exclude(emptyList()) }
            val kotlinDebugTree = fileTree("${project.buildDir}/tmp/kotlin-classes/debug") { exclude(emptyList()) }
            val unifiedTree = files(javaDebugTree, kotlinDebugTree)

            classDirectories.setFrom(unifiedTree)

            sourceDirectories.setFrom(files("$projectDir/src/main/java", "$projectDir/src/main/kotlin"))
            additionalSourceDirs.setFrom(files("$projectDir/src/main/java", "$projectDir/src/main/kotlin"))

            executionData.setFrom(files("${project.buildDir}/jacoco/testDebugUnitTest.exec"))

            doFirst {
                unifiedTree.files.forEach { file ->
                    if (file.name.contains("$$")) {
                        file.renameTo(file(file.path.replace("$$", "$")))
                    }
                }
            }
        }
    }

    private fun Project.addToRoot(project: Project, key: String, jacocoReport: JacocoReport, taskDescription: String): Task? {
        val coverageReportTask = getTask(key, jacocoReport, taskDescription)
        return coverageReportTask.configure(closureOf<JacocoReport> {
            dependsOn(project.tasks["moduleJacocoCoverageReport"])
        })
    }

    private fun Project.getTask(key: String, jacocoReport: JacocoReport, taskDescription: String): Task {
        return if (rootProject.tasks.findByPath(key) == null) {
            println("UMBO NEW ROOT")
            rootProject.plugins.apply("jacoco")
            rootProject.configure<JacocoPluginExtension> {
                toolVersion = "0.8.5"
            }
            rootProject.tasks.create(key, JacocoReport::class) {
                group = "Reporting"
                description = taskDescription
                executionData.setFrom(jacocoReport.executionData)
                classDirectories.setFrom(jacocoReport.classDirectories)
                sourceDirectories.setFrom(jacocoReport.sourceDirectories)

                reports {
                    xml.isEnabled = true
                    xml.destination = file("${rootProject.buildDir}/reports/jacoco/jacoco.xml")
                    html.isEnabled = true
                    html.destination = file("${rootProject.buildDir}/reports/jacoco")
                }
            }
        } else {
            println("UMBO ALREADY ROOT")
            rootProject.tasks.getByName(key, closureOf<JacocoReport> {
                executionData.from(jacocoReport.executionData)
                classDirectories.from(jacocoReport.classDirectories)
                sourceDirectories.from(jacocoReport.sourceDirectories)

                reports {
                    xml.isEnabled = true
                    xml.destination = file("${rootProject.buildDir}/reports/jacoco/jacoco.xml")
                    html.isEnabled = true
                    html.destination = file("${rootProject.buildDir}/reports/jacoco")
                }
            })
        }
    }
}

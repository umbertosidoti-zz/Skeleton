package com.umbo.skeleton

import com.umbo.skeleton.CoverageUtils.applyKotlinCodeCoverageOptions
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinCoveragePlugin: Plugin<Project> {

    override fun apply(project: Project): Unit = project.run {
        applyKotlinCodeCoverageOptions()
    }
}
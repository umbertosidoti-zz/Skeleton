package com.umbo.skeleton

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.umbo.skeleton.CodeCoverageOptions.applyAndroidCodeCoverageOptions

class AndroidCoveragePlugin: Plugin<Project> {

    override fun apply(project: Project): Unit = project.run {
        applyAndroidCodeCoverageOptions()
    }
}
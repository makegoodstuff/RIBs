import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    kotlin("multiplatform") version "1.3.31"
//    `java-library`
}

repositories {
    mavenCentral()
}

val kotlin_version: String by project

val iosFrameworkPrefix: String = "LoggedOut"

kotlin {
    jvm("android")

    val ios: KotlinNativeTarget
    if (false) {  // TODO: actually select a target depending on environment
        ios = iosArm64("ios")
    } else {
        ios = iosX64("ios")
    }

    println("Set up targets: ${targets.names} in ${project.name}")

    ios.binaries {
        val buildTypes = listOf<NativeBuildType>(DEBUG)
        framework(iosFrameworkPrefix, buildTypes)
    }

//    targets {
//        targetFromPreset(presets.getByName("iosX64"))
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }

        }

        val androidMain by getting {
            dependsOn(commonMain)
        }

        val iosMain by getting {
            dependsOn(commonMain)
        }
//        val commonTest by getting {
//            dependencies {
//                implementation("junit:junit:4.12")
//                implementation(kotlin("kotlin-test-common:${kotlin_version}"))
//                implementation(kotlin("kotlin-test-junit${kotlin_version}"))
//            }
//        }
    }
}

tasks {
    val build by existing
    val export by registering(Copy::class) {
        println("Exporting iOS Framework")
        val ios = kotlin.targets["ios"] as KotlinNativeTarget?
        if (ios != null) {
            val fmwk: Framework = ios.binaries.getFramework(iosFrameworkPrefix, NativeBuildType.DEBUG)

            from(fmwk.outputFile)
            val targetDirectory: String? by rootProject.extra

            if (targetDirectory != null) {
                println("Copying iOS Framework to $targetDirectory")
                into(targetDirectory as String)
            } else {
                println("iOS Framework exported to ${fmwk.outputFile}")
                into(fmwk.outputDirectory)
            }
        }

        dependsOn(build)
    }
}

var fmwkLocation: File? by project.extra

//    val copy by  {
//        if (fmwkLocation != null) {
//
//        }
//    }

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform") version "1.3.31"
//    `java-library`
}

repositories {
    mavenCentral()
}

val kotlin_version: String by project

kotlin {
    jvm("android")
    if (true) {  // TODO: actually select a target depending on environment
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val androidMain by getting {
//            kotlin.srcDir("src/androidMain")
            dependsOn(commonMain)
        }
        val iosMain by getting {
//            kotlin.srcDir("src/iosMain")
            dependsOn(commonMain)
        }
        // TODO: add binary {} directive and build the artifacts
//        val commonTest by getting {
//            dependencies {
//                implementation("junit:junit:4.12")
//                implementation(kotlin("kotlin-test-common:${kotlin_version}"))
//                implementation(kotlin("kotlin-test-junit${kotlin_version}"))
//            }
//        }
    }
}

// TODO: Add gradle task function which can be called from xcode (./gradelw TASK_NAME -Pparams)
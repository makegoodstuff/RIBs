buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    }

    // dependencies {
    //     val kotlin_version: String by project
    //     classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}")
    //     classpath("com.android.tools.build:gradle:3.4.0")
    // }
}

allprojects {
    group = "com.uber.rib"
    version = "0.3"

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

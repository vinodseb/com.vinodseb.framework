plugins {
    kotlin("jvm") version kotlin_version
    kotlin("plugin.serialization") version kotlin_version
    id("com.github.ben-manes.versions") version versions_version
    id("org.jlleitschuh.gradle.ktlint") version klint_version
}

allprojects {
    repositories {
        mavenCentral()
    }
}

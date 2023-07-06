plugins {
    kotlin("jvm") version kotlin_version
    kotlin("plugin.serialization") version kotlin_version
    id("com.github.ben-manes.versions") version versions_version
    id("org.jlleitschuh.gradle.ktlint") version klint_version
    id("io.gitlab.arturbosch.detekt") version detekt_version
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("io.gitlab.arturbosch.detekt")
    }

    detekt {
        config.setFrom("config/detekt/detekt.yml")
    }
}

plugins {
    kotlin("jvm") version kotlin_version
    kotlin("plugin.serialization") version kotlin_version
    id("com.github.ben-manes.versions") version versions_version
    id("org.jlleitschuh.gradle.ktlint") version klint_gradle_version
    id("io.gitlab.arturbosch.detekt") version detekt_version
    id("org.jetbrains.kotlinx.kover") version kover_version
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jetbrains.kotlinx.kover")
    }

    detekt {
        config.setFrom("config/detekt/detekt.yml")
    }

    dependencies {
        // Serialization dependency
        implementation("io.ktor:ktor-serialization-gson:$ktor_version")

        // Logging dependencies
        implementation("ch.qos.logback:logback-classic:$logback_version")

        // Test dependencies
        testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jlleitschuh.gradle.ktlint")
    `java-library`
}

dependencies {
    // Ktor dependencies
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

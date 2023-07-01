plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.20"
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

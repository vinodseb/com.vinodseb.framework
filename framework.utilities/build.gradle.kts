plugins {
    kotlin("plugin.serialization")
    `java-library`
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

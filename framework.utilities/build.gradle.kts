plugins {
    kotlin("plugin.serialization")
    `java-library`
}

dependencies {
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

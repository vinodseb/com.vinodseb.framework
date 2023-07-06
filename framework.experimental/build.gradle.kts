plugins {
    application
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    // Project dependencies
    implementation(project(":framework.utilities"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
}

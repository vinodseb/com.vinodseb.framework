plugins {
    `java-library`
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    // Project dependencies
    implementation(project(":framework.lib:framework.utilities"))
}

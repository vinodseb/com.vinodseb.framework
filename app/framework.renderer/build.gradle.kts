plugins {
    application
}

dependencies {
    // Ktor server dependencies
    implementation("io.ktor:ktor-server-swagger:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-mustache:$ktor_version")

    // Ktor client dependencies
    implementation("io.ktor:ktor-client-core:$ktor_version")
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
}

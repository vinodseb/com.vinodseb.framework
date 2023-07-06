plugins {
    application
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-config-yaml:$ktor_version")
    implementation("io.ktor:ktor-server-mustache:$ktor_version")
    implementation("io.ktor:ktor-server-swagger:$ktor_version")

    implementation("io.ktor:ktor-client-core:$ktor_version")

    // Test dependencies
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")

    // Project dependencies
    implementation(project(":lib:framework.utilities"))
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
}

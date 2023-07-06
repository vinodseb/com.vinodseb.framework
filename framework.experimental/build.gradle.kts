plugins {
    application
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    // Project dependencies
    implementation(project(":framework.utilities"))
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
}

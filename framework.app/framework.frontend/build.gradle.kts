apply {
    from("common.tasks.kts")
}

dependencies {
    // Ktor client dependencies
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
    project.tasks["build"].dependsOn("sass")
    project.tasks["clean"].dependsOn("npmClean")
}

plugins {
    application
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-config-yaml:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    // Test dependencies
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")

    // Project dependencies
    implementation(project(":framework.utilities"))

    // install required npm packages from gradle
    // implementation(npm("node-sass", ">=6.0"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
    project.tasks["build"].dependsOn("sass")
}

task<Exec>("sass") {
    dependsOn("npmInstall")
    workingDir("src/main/resources/static")
    commandLine("npm", "run", "sass")
}

task<Exec>("npmInstall") {
    workingDir("src/main/resources/static")
    commandLine("npm", "install")
}

dependencies {
    // Ktor client dependencies
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    // install required npm packages from gradle
    // implementation(npm("node-sass", ">=6.0"))
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
    project.tasks["build"].dependsOn("sass")
    project.tasks["clean"].dependsOn("npmClean")
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

task<Exec>("npmClean") {
    dependsOn("npmInstall")
    workingDir("src/main/resources/static")
    commandLine("npm", "run", "clean")
}

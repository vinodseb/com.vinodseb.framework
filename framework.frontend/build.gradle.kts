plugins {
    kotlin("jvm")
//    id("com.github.node-gradle.node") version "5.0.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-server-core:${ktor_version}")
    implementation("io.ktor:ktor-server-netty:${ktor_version}")
    implementation("io.ktor:ktor-server-content-negotiation:${ktor_version}")
    implementation("io.ktor:ktor-server-config-yaml:${ktor_version}")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:${ktor_version}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor_version}")

    // Logging dependencies
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // Test dependencies
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Project dependencies
    implementation(project(":framework.utilities"))

    //
    implementation(npm("node-sass", ">=6.0"))
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
    commandLine( "npm", "run", "sass")
}

task<Exec>("npmInstall") {
    workingDir("src/main/resources/static")
    commandLine( "npm", "install")
}

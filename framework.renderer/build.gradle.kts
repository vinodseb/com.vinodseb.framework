plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-server-config-yaml:${ktor_version}")
    implementation("io.ktor:ktor-server-mustache:$ktor_version")
    implementation("io.ktor:ktor-server-swagger:$ktor_version")

    implementation("io.ktor:ktor-client-core:$ktor_version")

    // Logging dependencies
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // Test dependencies
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

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

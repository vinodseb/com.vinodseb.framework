
subprojects {
    repositories {
        mavenCentral()
    }

    dependencies {
        // Server dependencies
        implementation("io.ktor:ktor-server-config-yaml:$ktor_version")
        implementation("io.ktor:ktor-server-core:$ktor_version")
        implementation("io.ktor:ktor-server-netty:$ktor_version")

        // Test dependencies
        testImplementation("io.ktor:ktor-server-test-host:$ktor_version")

        // Project dependencies
        implementation(project(":framework.lib:framework.utilities"))
    }
}

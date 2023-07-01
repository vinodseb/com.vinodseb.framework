plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    val ktorVersion = "2.3.2"
    val logbackVersion = "1.4.8"
    val kotlinVersion = "1.9.0-RC"

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-server-mustache:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    implementation(project(":framework.utilities"))

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("1.8.20")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("com.vinodseb.framework.AppKt")
}

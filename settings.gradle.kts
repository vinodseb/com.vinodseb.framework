plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "framework"

include(
        "framework.frontend",
        "framework.backend",
        "framework.utilities"
)

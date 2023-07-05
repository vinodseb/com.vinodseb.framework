plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "framework"

include("framework.frontend")
include("framework.backend")
include("framework.utilities")
include("framework.renderer")
include("framework.furniture")
include("framework.experimental")

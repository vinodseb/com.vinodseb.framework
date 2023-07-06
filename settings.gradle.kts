plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "framework"

include("app")
include("app:framework.frontend")
include("app:framework.backend")
include("app:framework.renderer")
include("app:framework.furniture")
include("lib")
include("lib:framework.utilities")
include("lib:framework.experimental")

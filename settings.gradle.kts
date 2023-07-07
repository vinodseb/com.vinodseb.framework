plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version foojay_toolchains_version
}

rootProject.name = "framework"

include("framework.app")
include("framework.app:framework.frontend")
include("framework.app:framework.backend")
include("framework.app:framework.renderer")
include("framework.app:framework.furniture")
include("framework.lib")
include("framework.lib:framework.utilities")
include("framework.lib:framework.experimental")

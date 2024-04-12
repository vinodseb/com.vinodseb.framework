plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "framework"

include(":framework.app")
include(":framework.app:framework.frontend")
include(":framework.app:framework.backend")
include(":framework.app:framework.renderer")
include(":framework.app:framework.furniture")
include(":framework.lib")
include(":framework.lib:framework.core")
include(":framework.lib:framework.experimental")

startParameter.setExcludedTaskNames(listOf(":framework.app:framework.furniture:run"))

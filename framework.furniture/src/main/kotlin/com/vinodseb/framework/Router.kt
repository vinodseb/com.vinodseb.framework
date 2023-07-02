package com.vinodseb.framework

import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Route.swaggerRoute() =
    swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

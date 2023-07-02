package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.swaggerRoute() =
    swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

fun Route.testRoute() = get("/test") {
    call.respond(Page("success"))
}

fun Route.pageRoute() = get("/...") {
    call.respond(Page(""))
}

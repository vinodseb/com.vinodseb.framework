package com.vinodseb.framework

import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.swaggerRoute() =
    swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

fun Route.testRoute() =
    get("/test") {
        call.respondText("<html><body>success</body></html>", ContentType.Text.Html)
    }

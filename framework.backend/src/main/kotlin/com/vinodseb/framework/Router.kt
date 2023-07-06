package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.http.CacheControl
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.swaggerRoute() =
    swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

fun Route.testRoute() = get("/test") {
    call.respond(Page("success"))
}

fun Route.pageRoute() = get("/...") {
    call.respond(Page(""))
}

fun Route.staticRoute() =
    staticResources("/admin", "admin", index = "home.json") {
        extensions("json")
        enableAutoHeadResponse()
        cacheControl {
            listOf(CacheControl.MaxAge(10000))
        }
        contentType {
            ContentType.Application.Json
        }
    }

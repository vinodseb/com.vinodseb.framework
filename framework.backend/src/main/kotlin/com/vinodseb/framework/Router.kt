package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
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

fun Route.staticRoute() =
    staticResources("/admin", "admin", index="home.json") {
        extensions("json")
        enableAutoHeadResponse()
        cacheControl{
            listOf(CacheControl.MaxAge(10000))
        }
        contentType{
            ContentType.Application.Json
        }
    }

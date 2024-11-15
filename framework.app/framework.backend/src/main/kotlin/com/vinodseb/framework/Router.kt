package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.http.CacheControl
import io.ktor.http.ContentType
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

const val CACHE_CONTROL_MAX_AGE = 10000

fun Routing.swaggerRoute() = swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

fun Routing.testRoute() =
    get("/test") {
        call.respond(Page(title = "success"))
    }

fun Routing.pageRoute() =
    get("/...") {
        call.respond(Page(""))
    }

fun Routing.staticRoute() =
    staticResources("/en/admin", "en/admin", index = "home.json") {
        extensions("json")
        enableAutoHeadResponse()
        cacheControl {
            listOf(CacheControl.MaxAge(CACHE_CONTROL_MAX_AGE))
        }
        contentType {
            ContentType.Application.Json
        }
    }

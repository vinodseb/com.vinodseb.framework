package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.mustache.MustacheContent
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.util.logging.KtorSimpleLogger

internal val Logger = KtorSimpleLogger("Routing")

fun Route.pageRoute() =
    post("/page") {
        val page = call.receive<Page>()

        Logger.info("Received page $page")

        call.respond(MustacheContent("page.hbs", mapOf("page" to page)))
    }

fun Route.swaggerRoute() = swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

fun Route.testRoute() =
    get("/test") {
        call.respondText("<div>furniture</div>", ContentType.Text.Html)
    }

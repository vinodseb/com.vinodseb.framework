package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.mustache.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*

internal val Logger = KtorSimpleLogger("Routing")

fun Route.pageRoute() =
    post("/page") {
        val page = call.receive<Page>()

        Logger.info("Received page $page")

        call.respond(MustacheContent("page.hbs", mapOf("page" to page)))
    }

fun Route.swaggerRoute() =
    swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

fun Route.testRoute() = get("/test") {
    call.respondText("<div>furniture</div>", ContentType.Text.Html)
}

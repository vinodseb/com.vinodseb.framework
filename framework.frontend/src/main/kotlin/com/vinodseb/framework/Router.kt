package com.vinodseb.framework

import com.vinodseb.framework.controller.handlePageRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.faviconRoute() {
    staticResources("/favicon.ico", "assets", "/images/favicon.svg")
}

fun Route.staticRoute() {
    staticResources("/static", "assets")
}

fun Route.pageRoute() = get("/page") {
    handlePageRequest()
        .fold(
            onSuccess = {
                call.respondText(it, ContentType.Text.Html)
            },
            onFailure = {
                call.respondText(it.message.toString())
            }
        )
}
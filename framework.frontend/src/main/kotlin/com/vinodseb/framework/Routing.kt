package com.vinodseb.framework

import com.vinodseb.framework.client.client
import com.vinodseb.framework.model.Page
import io.ktor.client.request.*
import io.ktor.client.statement.*
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
    runCatching {
        client.post("http://localhost:8082/page") {
            contentType(ContentType.Application.Json)
            setBody(Page("Some Random Title"))
        }
    }.fold(
            onSuccess = {
                call.respondText(it.bodyAsText(), ContentType.Text.Html)
            },
            onFailure = {
                call.respondText(it.message.toString())
            }
    )
}

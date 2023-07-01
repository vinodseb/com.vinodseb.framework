package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.mustache.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.favicon() {
    staticResources("/favicon.ico", "assets", "/images/favicon.svg")
}

fun Route.static() {
    staticResources("/static", "assets")
}

fun Route.hello() = get("/hello") {
    call.respondText("Hello")
}

fun Route.page() = get("/page") {
    val samplePage = Page("Random Title")
    call.respond(MustacheContent("page.hbs", mapOf("page" to samplePage)))
}

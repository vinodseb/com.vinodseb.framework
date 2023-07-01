package com.vinodseb.framework

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.favicon() {
    staticResources("/favicon.ico", "assets", "/images/favicon.svg")
}

fun Route.static() {
    staticResources("/static", "assets")
}

fun Route.page() = get("/page") {
    call.respond("Sample page test")
}

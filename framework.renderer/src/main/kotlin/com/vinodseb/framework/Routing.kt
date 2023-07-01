package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.server.application.*
import io.ktor.server.mustache.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.page() = get("/page") {
    val samplePage = Page("Random Title")
    call.respond(MustacheContent("page.hbs", mapOf("page" to samplePage)))
}

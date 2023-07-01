package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.server.application.*
import io.ktor.server.mustache.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pageRoute() =
        post("/page") {
            val page = call.receive<Page>()
            call.respond(MustacheContent("page.hbs", mapOf("page" to page)))
        }

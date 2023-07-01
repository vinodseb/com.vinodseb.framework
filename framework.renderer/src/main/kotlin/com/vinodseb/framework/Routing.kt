package com.vinodseb.framework

import com.vinodseb.framework.model.Page
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pageRoute() = get("/page") {
    call.respond(Page("Some Random Title"))
}

//.post("/page") {
//    val page = call.receive<Page>()
//    // TODO add some data processing example here
//    call.respond(MustacheContent("page.hbs", mapOf("page" to page)))
//}

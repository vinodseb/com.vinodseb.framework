package com.vinodseb.framework

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    routing {
        faviconRoute()
        staticRoute()
        pageRoute()
    }
}

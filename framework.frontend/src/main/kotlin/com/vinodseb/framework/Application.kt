package com.vinodseb.framework

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*

private val Log = KtorSimpleLogger("Application")

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {

    Log.info("Running application module")

    routing {
        faviconRoute()
        staticRoute()
        pageRoute()
    }
}


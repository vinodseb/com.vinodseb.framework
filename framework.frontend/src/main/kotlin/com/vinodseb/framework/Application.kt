package com.vinodseb.framework

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.routing.IgnoreTrailingSlash
import io.ktor.server.routing.routing
import io.ktor.util.logging.KtorSimpleLogger

private val Log = KtorSimpleLogger("Application")

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    Log.info("Running application module")

    install(IgnoreTrailingSlash)

    routing {
        faviconRoute()
        staticRoute()
        testRoute()
        pageRoute()
    }
}

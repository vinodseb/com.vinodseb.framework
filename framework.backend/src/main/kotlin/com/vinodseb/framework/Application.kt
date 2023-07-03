package com.vinodseb.framework

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*
import kotlinx.serialization.json.Json

private val Log = KtorSimpleLogger("Application")

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {

    Log.info("Running application module")

    install(IgnoreTrailingSlash)

    install(ContentNegotiation) {
        json(Json {
            isLenient = true
        })
    }

    routing {
        swaggerRoute()
        testRoute()
        pageRoute()
        staticRoute()
    }
}

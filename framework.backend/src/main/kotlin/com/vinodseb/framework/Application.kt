package com.vinodseb.framework

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*
import java.text.DateFormat

private val Log = KtorSimpleLogger("Application")

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {

    Log.info("Running application module")

    install(IgnoreTrailingSlash)

    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    routing {
        swaggerRoute()
        testRoute()
        pageRoute()
        staticRoute()
    }
}

package com.vinodseb.framework

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.mustache.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import java.text.DateFormat

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates")
    }
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
    }
}

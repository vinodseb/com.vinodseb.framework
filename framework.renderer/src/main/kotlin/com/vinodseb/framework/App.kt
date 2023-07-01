package com.vinodseb.framework

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.mustache.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8081) {
        install(Mustache) {
            mustacheFactory = DefaultMustacheFactory("templates")
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        routing {
            pageRoute()
        }
    }.start(wait = true)
}

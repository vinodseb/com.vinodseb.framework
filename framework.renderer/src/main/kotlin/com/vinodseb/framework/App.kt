package com.vinodseb.framework

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.mustache.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8081) {
        install(Mustache) {
            mustacheFactory = DefaultMustacheFactory("templates")
        }
        routing {
            page()
        }
    }.start(wait = true)
}

package com.vinodseb.framework

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*


fun main() {
    embeddedServer(Netty, port = 8080) {
//        install(Mustache)
        routing {
            favicon()
            static()
            hello()
        }

    }.start(wait = true)
}

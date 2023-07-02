package com.vinodseb.framework

import com.vinodseb.framework.controller.renderContent
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*

private val Log = KtorSimpleLogger("Router")

fun Route.faviconRoute() =
    staticResources("/favicon.ico", "assets", "/images/favicon.svg")

fun Route.staticRoute() =
    staticResources("/static", "assets")

fun Route.pageRoute() = get("{locale...}") {

    val locale = call.parameters["locale"].orEmpty()
    val path = call.request.path()

    Log.info("Locale: $locale")
    Log.info("Path: $path")

    when {
        isUnsupportedLocale(locale) -> call.respondText("Unsupported locale")
        else -> renderContent(path).fold(
            onSuccess = {
                call.respondText(it, ContentType.Text.Html)
            },
            onFailure = {
                call.respondText(it.message.toString())
            }
        )
    }
}

private fun isUnsupportedLocale(locale: String): Boolean =
    !"(en)|(de)".toRegex().containsMatchIn(locale)

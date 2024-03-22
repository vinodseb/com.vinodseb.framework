package com.vinodseb.framework

import com.vinodseb.framework.controller.renderContent
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.http.content.staticResources
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.util.logging.KtorSimpleLogger

private val Log = KtorSimpleLogger("Router")

fun Route.faviconRoute() = staticResources("/favicon.ico", "static", "/images/favicon.svg")

fun Route.staticRoute() = staticResources("/static", "static")

fun Route.testRoute() =
    get("/test") {
        call.respondText("<html><body>success</body></html>", ContentType.Text.Html)
    }

fun Route.pageRoute() =
    get("/{locale}/{path...}") {
        val locale = call.parameters["locale"].orEmpty()
        val path = call.parameters.getAll("path").orEmpty().joinToString("/")

        Log.info("Locale: $locale")
        Log.info("Path: $path")

        when {
            isUnsupportedLocale(locale) -> call.respondText("Unsupported locale")
            else ->
                renderContent(path).fold(
                    onSuccess = {
                        call.respondText(it, ContentType.Text.Html)
                    },
                    onFailure = {
                        call.respondText(it.message.toString())
                    },
                )
        }
    }

private fun isUnsupportedLocale(locale: String): Boolean = !"(en)|(de)".toRegex().containsMatchIn(locale)

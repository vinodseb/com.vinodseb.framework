package com.vinodseb.framework

import com.vinodseb.framework.client.BackendClient
import com.vinodseb.framework.client.RendererClient
import com.vinodseb.framework.controller.renderContent
import io.ktor.http.ContentType
import io.ktor.server.http.content.staticResources
import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.util.logging.KtorSimpleLogger

private val Log = KtorSimpleLogger("Router")

fun Routing.faviconRoute() = staticResources("/favicon.ico", "static", "/images/favicon.svg")

fun Routing.staticRoute() = staticResources("/static", "static")

fun Routing.testRoute() =
    get("/test") {
        call.respondText("<html><body>success</body></html>", ContentType.Text.Html)
    }

fun Routing.pageRoute(
    backendClient: BackendClient,
    rendererClient: RendererClient,
) = get("/{locale}/{path...}") {
    val locale = call.parameters["locale"].orEmpty()
    val path = call.parameters.getAll("path").orEmpty().joinToString("/")

    Log.info("Locale: $locale")
    Log.info("Path: $path")

    when {
        locale.isUnsupported() -> call.respondText("Unsupported locale")
        else ->
            renderContent("$locale/$path", backendClient, rendererClient).fold(
                onSuccess = {
                    call.respondText(it, ContentType.Text.Html)
                },
                onFailure = {
                    call.respondText(it.message.toString())
                },
            )
    }
}

private fun String.isUnsupported(): Boolean = listOf("en", "de").none { it == this }

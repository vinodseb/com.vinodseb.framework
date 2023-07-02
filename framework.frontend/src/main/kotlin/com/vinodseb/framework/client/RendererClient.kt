package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.logging.*
import kotlinx.serialization.json.Json

private val Log = KtorSimpleLogger("RendererClient")

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    install(Logging)
    expectSuccess = true
}

suspend fun postRenderRequest(page: Page) =
    client.post("http://localhost:8082/page") {
        contentType(ContentType.Application.Json)
        setBody(page)
    }.bodyAsText().also {
        Log.trace(it)
    }

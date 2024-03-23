package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.logging.KtorSimpleLogger

class RendererClient(engine: HttpClientEngine) : BaseClient(engine) {
    private val log = KtorSimpleLogger("RendererClient")

    suspend fun post(page: Page) =
        httpClient.post("http://localhost:8082/page") {
            contentType(ContentType.Application.Json)
            setBody(page)
        }.bodyAsText().also {
            log.trace(it)
        }
}

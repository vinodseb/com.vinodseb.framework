package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson
import io.ktor.util.logging.KtorSimpleLogger
import java.text.DateFormat

object RendererClient {
    private val Log = KtorSimpleLogger("RendererClient")

    private val client =
        HttpClient(CIO) {
            install(ContentNegotiation) {
                gson {
                    setDateFormat(DateFormat.LONG)
                    setPrettyPrinting()
                }
            }
            install(Logging)
            expectSuccess = true
        }

    suspend fun post(page: Page) =
        client.post("http://localhost:8082/page") {
            contentType(ContentType.Application.Json)
            setBody(page)
        }.bodyAsText().also {
            Log.trace(it)
        }
}

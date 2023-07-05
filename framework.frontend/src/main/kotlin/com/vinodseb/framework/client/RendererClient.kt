package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.util.logging.*
import java.text.DateFormat

object RendererClient {

    private val Log = KtorSimpleLogger("RendererClient")

    private val client = HttpClient(CIO) {
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

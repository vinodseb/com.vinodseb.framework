package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import io.ktor.util.logging.KtorSimpleLogger
import java.text.DateFormat

object BackendClient {
    private val Log = KtorSimpleLogger("BackendClient")

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

    suspend fun get(path: String): Page =
        client.get("http://localhost:8081/$path").body<Page>().also {
            Log.info("Requested path: $path")
        }
}

package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.logging.*
import kotlinx.serialization.json.Json

object BackendClient {

    private val Log = KtorSimpleLogger("BackendClient")

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging)
        expectSuccess = true
    }

    suspend fun get(path: String): Page =
        client.get("http://localhost:8081/$path").body<Page>().also {
            Log.info("Requested path: $path")
        }
}


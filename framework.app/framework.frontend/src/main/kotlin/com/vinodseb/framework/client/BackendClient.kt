package com.vinodseb.framework.client

import com.vinodseb.framework.model.Page
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.get
import io.ktor.util.logging.KtorSimpleLogger

class BackendClient(engine: HttpClientEngine) : BaseClient(engine) {
    private val log = KtorSimpleLogger("BackendClient")

    suspend fun get(path: String): Page =
        httpClient.get("http://localhost:8081/$path").body<Page>().also {
            log.info("Requested path: $path")
        }
}

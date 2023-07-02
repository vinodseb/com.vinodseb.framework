package com.vinodseb.framework.controller

import com.vinodseb.framework.client.client
import com.vinodseb.framework.model.Page
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.logging.*

private val Log = KtorSimpleLogger("PageController")
suspend fun handlePageRequest(path: String) =
    runCatching {
        client.post("http://localhost:8082/page") {
            contentType(ContentType.Application.Json)
            setBody(Page("Some Random Title $path"))
        }.bodyAsText().also {
            Log.trace(it)
        }
    }

package com.vinodseb.framework.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.gson.gson
import java.text.DateFormat

abstract class BaseClient(engine: HttpClientEngine) {
    val httpClient =
        HttpClient(engine) {
            install(ContentNegotiation) {
                gson {
                    setDateFormat(DateFormat.DEFAULT, DateFormat.DEFAULT)
                    setPrettyPrinting()
                }
            }
            install(Logging)
            expectSuccess = true
        }
}

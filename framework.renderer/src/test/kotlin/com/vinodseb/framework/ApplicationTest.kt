package com.vinodseb.framework

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `test endpoint should return success`() = testApplication {
        client.get("/test").let {
            assertEquals(HttpStatusCode.OK, it.status)
            assertEquals("<div>furniture</div>", it.bodyAsText())
        }
    }
}

package com.vinodseb.framework

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() =
        testApplication {
            application {
                module()
            }
            client.get("/test").let {
                assertEquals(HttpStatusCode.OK, it.status)
                assertEquals("<html><body>success</body></html>", it.bodyAsText())
            }
        }
}

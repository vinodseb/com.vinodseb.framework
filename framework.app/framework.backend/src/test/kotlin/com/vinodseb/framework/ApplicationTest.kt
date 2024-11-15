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
                assertEquals(
                    "{\n" +
                        "  \"lang\": \"zxx\",\n" +
                        "  \"title\": \"success\",\n" +
                        "  \"header\": {},\n" +
                        "  \"banner\": {},\n" +
                        "  \"footer\": {},\n" +
                        "  \"main\": [],\n" +
                        "  \"sidebar\": []\n" +
                        "}",
                    it.bodyAsText(),
                )
            }
        }
}

package com.vinodseb.framework

import com.vinodseb.framework.experiment.jsonToPage
import com.vinodseb.framework.experiment.pageToJson
import com.vinodseb.framework.model.Page
import com.vinodseb.framework.model.component
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `test jsonToPage()`() =
        jsonToPage("""
            {
                "title": "Some Random Page",
                "header": {
                    "content": "header content"
                },
                "banner": {
                    "header": "Banner Header",
                    "content": "banner content",
                    "image": "http://www.image.com/image.jpg",
                    "link": "http://localhost:8080/en/admin/home"
                },
                "footer": {
                    "content": "Footer content"
                },
                "main": [
                ],
                "sidebar": [
                ]
            }
        """).run {
            assertEquals("Footer content", this.footer["content"])
        }

    @Test
    fun `test pageToJson()`() =
        pageToJson(Page(
            title = "",
            footer = component( "content" to "Footer content" )
        )).run {
            assertEquals(
                "{\"title\":\"\",\"header\":{},\"banner\":{},\"footer\":{\"content\":\"Footer content\"},\"main\":[],\"sidebar\":[]}",
                this)
        }
}
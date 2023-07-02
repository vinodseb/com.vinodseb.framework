package com.vinodseb.framework.controller

import com.vinodseb.framework.client.postRenderRequest
import com.vinodseb.framework.model.Page

suspend fun renderContent(path: String) =
    runCatching {
        postRenderRequest(Page(path))
    }

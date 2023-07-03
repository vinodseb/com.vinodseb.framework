package com.vinodseb.framework.controller

import com.vinodseb.framework.client.BackendClient
import com.vinodseb.framework.client.RendererClient

suspend fun renderContent(path: String) =
    runCatching {
        BackendClient.get(path).let {
            RendererClient.post(it)
        }
    }

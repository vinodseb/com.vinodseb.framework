package com.vinodseb.framework.controller

import com.vinodseb.framework.client.BackendClient
import com.vinodseb.framework.client.RendererClient

suspend fun renderContent(
    path: String,
    backendClient: BackendClient,
    rendererClient: RendererClient,
) = runCatching {
    backendClient.get(path).let {
        rendererClient.post(it)
    }
}

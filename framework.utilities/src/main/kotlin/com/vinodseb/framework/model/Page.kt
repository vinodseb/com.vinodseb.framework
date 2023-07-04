package com.vinodseb.framework.model

import kotlinx.serialization.Serializable

@Serializable
data class Page(
    val title: String,
    val header: Component = mapOf(),
    val banner: Component = mapOf(),
    val main: Region = listOf(),
    val sidebar: Region = listOf()
)

typealias Region = List<Component>

typealias Component = Map<String, String>

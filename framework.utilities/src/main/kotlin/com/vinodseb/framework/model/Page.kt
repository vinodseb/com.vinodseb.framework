package com.vinodseb.framework.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Page(
    val title: String,
    val header: Header? = null,
    val footer: Footer? = null,
    val body: Body? = null
)

@Serializable
data class Header(
    val logo: Component?,
    val menu: Component?,
    val search: Component?
)

@Serializable
data class Footer(
    val corporate: Component,
    val global: Component
)

@Serializable
data class Body(
    val top: Region?,
    val left: Region?,
    val main: Region?,
    val right: Region?,
    val bottom: Region?
)

typealias Region = List<Component>

typealias Component = Map<String, @Contextual Any>
package com.vinodseb.framework.model

data class Page(
    val title: String,
    val header: Component = component(),
    val banner: Component = component(),
    val footer: Component = component(),
    val main: Region = listOf(),
    val sidebar: Region = listOf()
)

typealias Region = List<Component>

typealias Component = Map<String, *>
fun component(vararg pair: Pair<String, Any>) = mapOf(*pair)

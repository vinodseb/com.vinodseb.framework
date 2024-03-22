package com.vinodseb.framework.model

data class Page(
    var lang: String = "zxx",
    var title: String = "",
    var header: Component = componentOf(),
    var banner: Component = componentOf(),
    var footer: Component = componentOf(),
    var main: Region = regionOf(),
    var sidebar: Region = regionOf(),
)

typealias Component = HashMap<String, *>

fun componentOf(vararg pair: Pair<String, Any>) = hashMapOf(*pair)

typealias Region = List<Component>

fun regionOf(vararg component: Component) = listOf(*component)

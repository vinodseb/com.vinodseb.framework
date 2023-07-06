package com.vinodseb.framework.experiment

fun main() {
    val page = newPage("page title", "page heading")
    println(page.title)
    println(page.heading)
}

data class Page1(
    val title: String = "",
    val heading: String = ""
)

val newPage: (String, String) -> Page1 = {
        title, heading: String ->
    Page1(title, heading)
}

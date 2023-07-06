package com.vinodseb.framework.experiment

data class Page2(var title: String = "")

fun page2(block: Page2.() -> Unit): Page2 {
    val page2 = Page2()
    page2.block()
    return page2
}

data class Page3(var title: String = "")

fun page3(block: Page3.() -> Unit): Page3 {
    return Page3().apply(block)
}

data class Page4(var title: String = "")

fun page4(block: Page4.() -> Unit): Page4 = Page4().apply(block)

fun main() {
    page2 {
        title = "page2 title"
    }.also {
        println(it.title)
    }

    page3 {
        title = "page3 title"
    }.also {
        println(it.title)
    }

    page4 {
        title = "page4 title"
    }.also {
        println(it.title)
    }
}

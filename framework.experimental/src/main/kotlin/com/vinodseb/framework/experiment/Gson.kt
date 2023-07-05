package com.vinodseb.framework.experiment

import com.google.gson.Gson
import com.vinodseb.framework.model.Page

val gson = Gson()

//val type: Type = object : TypeToken<Map<String, *>>() {}.type

//fun Component.property(name: String): String =
//    get(name) as String

fun jsonToPage(string: String): Page =
    gson.fromJson(string, Page::class.java)

fun pageToJson(page: Page) =
    gson.toJson(page)

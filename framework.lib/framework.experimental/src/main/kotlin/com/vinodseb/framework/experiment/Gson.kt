package com.vinodseb.framework.experiment

import com.google.gson.Gson
import com.vinodseb.framework.model.Page

val gson = Gson()

fun jsonToPage(string: String): Page = gson.fromJson(string, Page::class.java)

fun pageToJson(page: Page): String = gson.toJson(page)

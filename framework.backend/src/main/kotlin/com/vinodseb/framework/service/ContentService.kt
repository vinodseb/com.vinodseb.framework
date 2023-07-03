package com.vinodseb.framework.service

object ContentService {
    fun load(path: String) =
        runCatching {
            javaClass.getResource(path)?.readText()
        }
}

package com.vinodseb.framework

import com.google.gson.Gson

fun main() {

    val gson = Gson()
    val component = gson.fromJson("""
        {
          "name": "test",
          "template": "test",
          "items": [
            {
                "name": "test2a",
                "template": "testtemplate",
                "items": [
                    {
                        "name": "test3",
                        "template": "testtemplate",
                        "items": []
                    }
                ]
            },
            {
                "name": "test2b",
                "template": "testtemplate",
                "items": []
            }
          ]
        }
        """, Map::class.java)


    println(gson.toJson(component))
}

typealias Component = Map<String, *>


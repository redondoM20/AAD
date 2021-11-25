package com.mrredondo.aad.ut01.ex02.app

interface JsonSerializer {
    fun <T> toJson(obj: T, typeClass: Class<T>): String
    fun <T> fromJson(json: String, typeClass: Class<T>): T
}
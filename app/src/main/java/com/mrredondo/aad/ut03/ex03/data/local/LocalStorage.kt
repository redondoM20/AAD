package com.mrredondo.aad.ut03.ex03.data.local

interface LocalStorage<T> {
    fun save(model: List<T>)
    fun fetch(id: String): T
    fun fetchAll(): List<T>
}

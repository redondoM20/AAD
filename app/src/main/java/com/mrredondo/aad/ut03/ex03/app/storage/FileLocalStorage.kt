package com.mrredondo.aad.ut03.ex03.app.storage


class FileLocalStorage<T: LocalModel> : LocalStorage<T> {
    override fun fetch(modelId: String, typeClass: Class<T>): T? {
        TODO("Not yet implemented")
    }

    override fun save(model: T, typeClass: Class<T>) {
        TODO("Not yet implemented")
    }
}
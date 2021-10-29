package com.mrredondo.aad.ut02.exercise03.data

class AppRepository(
    private val localStorage: LocalStorage<AppModel>
) {
    fun save(app: AppModel){
        localStorage.save(app)
    }

    fun fetch(id: Int): AppModel? = localStorage.fetch(id.toString())

}
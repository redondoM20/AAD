package com.mrredondo.aad.ut02.exercise02

class TapaRepository(private val localStorage: LocalStorage<TapaLocalModel>) {
    fun save(tapa: TapaLocalModel) {
        localStorage.save(tapa)
    }

    fun fetch(id: Int): TapaLocalModel? = localStorage.fetch(id.toString())
}
package com.mrredondo.aad.ut02.exercise02

class TapaRepository(private val localStorage: LocalStorage<TapaLocalModel>) {
    fun save(tapa: TapaLocalModel) {
        localStorage.save(tapa, TapaLocalModel::class.java)
    }

    fun fetch(id: Int): TapaLocalModel? = localStorage.fetch(id.toString(), TapaLocalModel::class.java)
}
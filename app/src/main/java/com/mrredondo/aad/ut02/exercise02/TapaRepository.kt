package com.mrredondo.aad.ut02.exercise02

class TapaRepository(private val dataSource: DataSource<TapaLocalModel>) {
    fun save(tapa: TapaLocalModel) {
        dataSource.save(tapa)
    }

    fun fetch(id: Int): TapaLocalModel? {
        var tapa = dataSource.fetch(id)
        return tapa
    }
}
package com.mrredondo.aad.ut03.ex06.data.local

import com.mrredondo.aad.ut03.ex06.domain.TapaModel

interface LocalDataSource {
    fun findAll(): Result<List<TapaModel>>
    fun saveAll(tapas: Result<List<TapaModel>>)
    fun save(tapa: Result<TapaModel>)
    fun findById(tapaId: String): Result<TapaModel>
}
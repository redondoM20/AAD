package com.mrredondo.aad.ut03.ex06.domain

interface TapaRepository {
    fun fetchTapas(): Result<List<TapaModel>>
    fun fetchTapa(tapaId: String): Result<TapaModel>
}
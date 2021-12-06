package com.mrredondo.aad.ut03.ex06.domain

class GetTapaUseCase (private val repository: TapaRepository){
    fun execute(tapaId: String): Result<TapaModel>{
        return repository.fetchTapa(tapaId)
    }
}
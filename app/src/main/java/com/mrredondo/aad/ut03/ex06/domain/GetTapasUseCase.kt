package com.mrredondo.aad.ut03.ex06.domain

class GetTapasUseCase (private val repository: TapaRepository){
    fun execute(): Result<List<TapaModel>>{
        return repository.fetchTapas()
    }
}
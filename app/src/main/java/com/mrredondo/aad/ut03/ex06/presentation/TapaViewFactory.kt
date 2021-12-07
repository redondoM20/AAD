package com.mrredondo.aad.ut03.ex06.presentation

import com.mrredondo.aad.ut03.ex06.data.TapaDataRepository
import com.mrredondo.aad.ut03.ex06.data.local.LocalDataSource
import com.mrredondo.aad.ut03.ex06.data.remote.MockDataSource
import com.mrredondo.aad.ut03.ex06.domain.GetTapaUseCase
import com.mrredondo.aad.ut03.ex06.domain.GetTapasUseCase

class TapaViewFactory {
    companion object{
        fun build(localDataSource: LocalDataSource): Ut03Ex06ViewModel{
            val repository = TapaDataRepository(localDataSource, MockDataSource())
            return Ut03Ex06ViewModel(GetTapasUseCase(repository), GetTapaUseCase(repository))
        }
    }
}
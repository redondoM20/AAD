package com.mrredondo.aad.ut03.ex06.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrredondo.aad.ut03.ex06.data.TapaDataRepository
import com.mrredondo.aad.ut03.ex06.data.remote.MockDataSource
import com.mrredondo.aad.ut03.ex06.domain.Failure
import com.mrredondo.aad.ut03.ex06.domain.GetTapaUseCase
import com.mrredondo.aad.ut03.ex06.domain.GetTapasUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex06ViewModel(
    private val getTapasUseCase: GetTapasUseCase,
    private val getTapaUseCase: GetTapaUseCase
) : ViewModel() {

    fun getTapas() = viewModelScope.launch(Dispatchers.Main) {
        val tapas = getTapasUseCase.execute()
        tapas.mapCatching {
            Log.d("@dev", "$it")
        }
    }

    fun findTapaById(tapaId: String) = viewModelScope.launch(Dispatchers.Main) {
        val tapa = getTapaUseCase.execute(tapaId)
        tapa.mapCatching {
            Log.d("@dev", "$it")
        }
    }
}
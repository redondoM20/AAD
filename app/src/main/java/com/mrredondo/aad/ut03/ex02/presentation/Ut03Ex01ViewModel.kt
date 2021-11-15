package com.mrredondo.aad.ut03.ex02.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrredondo.aad.ut03.ex02.data.PersonDataRepository
import com.mrredondo.aad.ut03.ex02.data.PersonLocalSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex01ViewModel() : ViewModel() {
    private val TAG = Example02Activity::class.java.simpleName
    fun getPersonsViewModelScope(context: Context){
        val repository = PersonDataRepository(PersonLocalSource(context))

        viewModelScope.launch(Dispatchers.Main) {
            val person = repository.fetchAll()
            Log.d(TAG, "$person")
        }
    }
}
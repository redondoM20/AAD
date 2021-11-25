package com.mrredondo.aad.ut01.ex02.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrredondo.aad.ut01.ex02.data.CustomerFileLocalSource
import com.mrredondo.aad_playground.ut01.ex02.CustomerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut01Ex02ViewModel(private val customerFileLocalSource: CustomerFileLocalSource) : ViewModel() {
    fun saveCustomer() = viewModelScope.launch(Dispatchers.Main){
        customerFileLocalSource.save(
            CustomerModel(1, "name1", "surname1")
        )
    }

    fun saveCustomers() = viewModelScope.launch(Dispatchers.Main){
        customerFileLocalSource.save(
            mutableListOf(

            )
        )
    }

    fun fetchCustomers() = viewModelScope.launch(Dispatchers.Main){
        val customers = customerFileLocalSource.fetch()
        Log.d("@dev", "$customers")
    }

    fun findById(customerId: Int) = viewModelScope.launch(Dispatchers.Main){
        val customer = customerFileLocalSource.findById(customerId)
        Log.d("@dev", "$customer")
    }
}
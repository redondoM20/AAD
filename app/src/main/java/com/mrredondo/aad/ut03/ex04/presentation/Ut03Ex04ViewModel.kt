package com.mrredondo.aad.ut03.ex04.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.customer.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex04ViewModel(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val getCustomerUseCase: GetCustomerUseCase,
    private val saveCustomerUseCase: SaveCustomerUseCase,
    private val deleteCustomerUseCase: DeleteCustomerUseCase,
    private val updateCustomerUseCase: UpdateCustomerUseCase
) : ViewModel() {

    fun getCustomers() = viewModelScope.launch(Dispatchers.IO) {
        val customers = getCustomersUseCase.execute()
        Log.d("@dev", "$customers")
    }

    fun getCustomer(customerId: Int) = viewModelScope.launch(Dispatchers.IO) {
        val customer = getCustomerUseCase.execute(customerId)
        Log.d("@dev", "$customer")
    }

    fun saveCustomer(customerModel: CustomerModel) = viewModelScope.launch(Dispatchers.IO){
        saveCustomerUseCase.execute(customerModel)
    }

    fun deleteCustomer(customerModel: CustomerModel) = viewModelScope.launch(Dispatchers.IO){
        deleteCustomerUseCase.execute(customerModel)
    }

    fun updateCustomer(customerModel: CustomerModel) = viewModelScope.launch(Dispatchers.IO){
        updateCustomerUseCase.execute(customerModel)
    }

}


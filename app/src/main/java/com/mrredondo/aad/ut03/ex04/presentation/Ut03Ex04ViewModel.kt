package com.mrredondo.aad.ut03.ex04.presentation

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
    private val _customers: MutableLiveData<CustomersViewState> by lazy {
        MutableLiveData<CustomersViewState>()
    }

    val customersObservable: LiveData<CustomersViewState>
        get() = _customers

    private val _customer: MutableLiveData<CustomerViewState> by lazy {
        MutableLiveData<CustomerViewState>()
    }

    val customerObservable: LiveData<CustomerViewState>
        get() = _customer

    fun getCustomers() = viewModelScope.launch(Dispatchers.Main) {
        val customers = getCustomersUseCase.execute()
        _customers.value = CustomersViewState(customers)
    }

    fun getCustomer(customerId: Int) = viewModelScope.launch(Dispatchers.Main) {
        val customer = getCustomerUseCase.execute(customerId)
        _customer.value = CustomerViewState(customer)
    }

    fun saveCustomer(customerModel: CustomerModel) = viewModelScope.launch(Dispatchers.IO){
        saveCustomerUseCase.execute(customerModel)
    }

    fun deleteCustomer(customerModel: CustomerModel) = viewModelScope.launch(Dispatchers.Main){
        deleteCustomerUseCase.execute(customerModel)
    }

    fun updateCustomer(customerModel: CustomerModel) = viewModelScope.launch(Dispatchers.Main){
        updateCustomerUseCase.execute(customerModel)
    }

}


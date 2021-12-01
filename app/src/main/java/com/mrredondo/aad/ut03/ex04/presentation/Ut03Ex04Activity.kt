package com.mrredondo.aad.ut03.ex04.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrredondo.aad.R
import com.mrredondo.aad.ut03.ex04.data.CustomerDataRepository
import com.mrredondo.aad.ut03.ex04.data.CustomerDbLocalSource
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.customer.*

class Ut03Ex04Activity : AppCompatActivity() {


    private val repository: CustomerDataRepository by lazy {
        CustomerDataRepository(CustomerDbLocalSource(applicationContext))
    }

    private val viewModel: Ut03Ex04ViewModel by lazy {
        Ut03Ex04ViewModel(
            GetCustomersUseCase(repository),
            GetCustomerUseCase(repository),
            SaveCustomerUseCase(repository),
            DeleteCustomerUseCase(repository),
            UpdateCustomerUseCase(repository)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        saveCustomer()
        loadCustomers()
        loadCustomer(3)
        deleteCustomer()
        updateCustomer()
    }

    private fun saveCustomer(){
        viewModel.saveCustomer(CustomerModel(1, "name01", "surname01"))
        viewModel.saveCustomer(CustomerModel(2, "name02", "surname02"))
        viewModel.saveCustomer(CustomerModel(3, "name03", "surname03"))
    }

    private fun loadCustomers(){
        viewModel.getCustomers()
    }

    private fun loadCustomer(customerId: Int){
        viewModel.getCustomer(customerId)
    }

    private fun deleteCustomer(){
        viewModel.deleteCustomer(CustomerModel(2, "name02", "surname02"))
    }

    private fun updateCustomer(){
        viewModel.updateCustomer(CustomerModel(3, "name04", "surname05"))
    }

}
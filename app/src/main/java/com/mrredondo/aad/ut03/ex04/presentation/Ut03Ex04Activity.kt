package com.mrredondo.aad.ut03.ex04.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrredondo.aad.R
import com.mrredondo.aad.ut03.ex04.data.CustomerDataRepository
import com.mrredondo.aad.ut03.ex04.data.CustomerDbLocalSource
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel
import com.mrredondo.aad.ut03.ex04.domain.customer.*
import com.mrredondo.aad.ut03.ex04.domain.product.*

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
            UpdateCustomerUseCase(repository),
            GetProductsUseCase(repository),
            GetProductUseCase(repository),
            SaveProductUseCase(repository),
            DeleteProductUseCase(repository),
            UpdateProductUseCase(repository)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        saveCustomers()
        loadCustomers()
        loadCustomer(3)
        deleteCustomer()
        updateCustomer()
        saveProducts()
        loadProducts()
        loadProduct(3)
        deleteProduct()
        updateProduct()
    }

    private fun saveCustomers(){
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

    private fun saveProducts(){
        viewModel.saveProduct(ProductModel(1, "name01", "model01", 11.1))
        viewModel.saveProduct(ProductModel(2, "name02", "model02", 22.2))
        viewModel.saveProduct(ProductModel(3, "name03", "model03", 33.3))
    }

    private fun loadProducts(){
        viewModel.getProducts()
    }

    private fun loadProduct(productId: Int){
        viewModel.getProduct(productId)
    }

    private fun deleteProduct(){
        viewModel.deleteProduct(ProductModel(2, "name02", "model02", 22.2))
    }

    private fun updateProduct(){
        viewModel.updateProduct(ProductModel(3, "name04", "model05", 33.3))
    }
}
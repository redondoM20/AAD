package com.mrredondo.aad.ut03.ex04.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel
import com.mrredondo.aad.ut03.ex04.domain.customer.*
import com.mrredondo.aad.ut03.ex04.domain.product.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex04ViewModel(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val getCustomerUseCase: GetCustomerUseCase,
    private val saveCustomerUseCase: SaveCustomerUseCase,
    private val deleteCustomerUseCase: DeleteCustomerUseCase,
    private val updateCustomerUseCase: UpdateCustomerUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductUseCase: GetProductUseCase,
    private val saveProductUseCase: SaveProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase
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

    fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        val products = getProductsUseCase.execute()
        Log.d("@dev", "$products")
    }

    fun getProduct(productId: Int) = viewModelScope.launch(Dispatchers.IO) {
        val product = getProductUseCase.execute(productId)
        Log.d("@dev", "$product")
    }

    fun saveProduct(productModel: ProductModel) = viewModelScope.launch(Dispatchers.IO){
        saveProductUseCase.execute(productModel)
    }

    fun deleteProduct(productModel: ProductModel) = viewModelScope.launch(Dispatchers.IO){
        deleteProductUseCase.execute(productModel)
    }

    fun updateProduct(productModel: ProductModel) = viewModelScope.launch(Dispatchers.IO){
        updateProductUseCase.execute(productModel)
    }

}


package com.mrredondo.aad.ut03.ex04.data

import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel

class CustomerDataRepository (private val customerDbLocalSource: CustomerDbLocalSource){
    fun findAllCustomer(): List<CustomerModel>{
        return customerDbLocalSource.findAllCustomer()
    }

    fun findByIdCustomer(customerId: Int): CustomerModel{
        return customerDbLocalSource.findByIdCustomer(customerId)
    }

    fun saveCustomer(customerModel: CustomerModel){
        customerDbLocalSource.saveCustomer(customerModel)
    }

    fun deleteCustomer(customerModel: CustomerModel){
        customerDbLocalSource.deleteCustomer(customerModel)
    }

    fun updateCustomer(customerModel: CustomerModel){
        customerDbLocalSource.updateCustomer(customerModel)
    }

    fun findAllProduct(): List<ProductModel>{
        return customerDbLocalSource.findAllProduct()
    }

    fun findByIdProduct(productId: Int): ProductModel {
        return customerDbLocalSource.findByIdProduct(productId)
    }

    fun saveProduct(productModel: ProductModel){
        customerDbLocalSource.saveProduct(productModel)
    }

    fun deleteProduct(productModel: ProductModel){
        customerDbLocalSource.deleteProduct(productModel)
    }

    fun updateProduct(productModel: ProductModel){
        customerDbLocalSource.updateProduct(productModel)
    }
}
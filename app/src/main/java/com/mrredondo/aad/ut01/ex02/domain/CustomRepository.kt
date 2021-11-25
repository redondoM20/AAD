package com.mrredondo.aad.ut01.ex02.domain

import com.mrredondo.aad.ut01.ex02.data.CustomerFileLocalSource
import com.mrredondo.aad_playground.ut01.ex02.CustomerModel

class CustomRepository (private val customerFileLocalSource: CustomerFileLocalSource){
    fun save(customer: CustomerModel){
        customerFileLocalSource.save(customer)
    }
    fun save(customers: List<CustomerModel>){
        customerFileLocalSource.save(customers)
    }
    fun fetch(): List<CustomerModel>{
        val customers = customerFileLocalSource.fetch()
        return customers
    }
    fun findById(customerId: Int): CustomerModel?{
        val customer = customerFileLocalSource.findById(customerId)
        return customer
    }
}
package com.mrredondo.aad.ut03.ex04.domain.customer

import com.mrredondo.aad.ut03.ex04.data.CustomerDataRepository
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel

class GetCustomersUseCase (private val repository: CustomerDataRepository){
    fun execute(): List<CustomerModel> = repository.findAllCustomer()
}
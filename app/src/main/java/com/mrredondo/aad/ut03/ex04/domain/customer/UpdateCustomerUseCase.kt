package com.mrredondo.aad.ut03.ex04.domain.customer

import com.mrredondo.aad.ut03.ex04.data.CustomerDataRepository
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel

class UpdateCustomerUseCase (private val repository: CustomerDataRepository){
    fun execute(customerModel: CustomerModel) = repository.updateCustomer(customerModel)
}
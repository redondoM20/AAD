package com.mrredondo.aad.ut03.ex04.domain.product

import com.mrredondo.aad.ut03.ex04.data.CustomerDataRepository
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel

class GetProductsUseCase (private val repository: CustomerDataRepository){
    fun execute(): List<ProductModel> = repository.findAllProduct()
}
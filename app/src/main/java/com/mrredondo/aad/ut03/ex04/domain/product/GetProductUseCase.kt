package com.mrredondo.aad.ut03.ex04.domain.product

import com.mrredondo.aad.ut03.ex04.data.CustomerDataRepository
import com.mrredondo.aad.ut03.ex04.domain.CustomerModel
import com.mrredondo.aad.ut03.ex04.domain.ProductModel

class GetProductUseCase(private val repository: CustomerDataRepository) {
    fun execute(productId: Int): ProductModel = repository.findByIdProduct(productId)
}
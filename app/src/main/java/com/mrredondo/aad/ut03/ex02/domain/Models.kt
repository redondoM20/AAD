package com.mrredondo.aad.ut03.ex02.domain

data class PersonModel(
    val id: Int,
    val name: String,
    val age: Int,
    val address: String?,
    val petModel: PetModel,
    val carModel: MutableList<CarModel>
)

data class PetModel(val id: Int, val name: String, val age: Int)

data class CarModel(val id: Int, val brand: String, val model: String)
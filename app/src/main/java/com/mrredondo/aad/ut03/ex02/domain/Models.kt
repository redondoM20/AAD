package com.mrredondo.aad.ut03.ex02.domain

data class PersonModel(
    val id: Int,
    val name: String,
    val age: Int,
    val address: String?,
    val petModel: PetModel
)

data class PetModel(val id: Int, val name: String, val age: Int)
package com.mrredondo.aad.ut03.ex02.domain

interface PersonRepository {
    fun savePerson(personModel: PersonModel)
}
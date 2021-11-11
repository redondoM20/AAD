package com.mrredondo.aad.ut03.ex02.domain

import com.mrredondo.aad.ut03.ex02.data.PersonAndPet

interface PersonRepository {
    fun savePerson(personModel: PersonModel)
    fun fetchAll(): List<PersonModel>
}
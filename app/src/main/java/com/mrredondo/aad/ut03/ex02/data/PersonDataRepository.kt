package com.mrredondo.aad.ut03.ex02.data

import com.mrredondo.aad.ut03.ex02.domain.PersonModel
import com.mrredondo.aad.ut03.ex02.domain.PersonRepository

class PersonDataRepository(private val personLocalSource: PersonLocalSource) : PersonRepository{
    override fun savePerson(personModel: PersonModel){


    }
}
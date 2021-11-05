package com.mrredondo.aad.ut03.ex02.data

import android.content.Context
import com.mrredondo.aad.ut03.ex02.app.Ut03Ex02Database
import com.mrredondo.aad.ut03.ex02.domain.PersonModel

class PersonLocalSource (applicatioContext: Context) {
    private val db = Ut03Ex02Database.getInstance(applicatioContext)

    fun  findAll(): List<PersonModel>{
        val people = db.personDao().findAll()
        return people.map { peopleEntity -> peopleEntity.toModel() }
    }
}
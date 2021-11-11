package com.mrredondo.aad.ut03.ex02.data

import android.content.Context
import com.mrredondo.aad.ut03.ex02.app.Ut03Ex02Database
import com.mrredondo.aad.ut03.ex02.domain.PersonModel

class PersonLocalSource(applicationContext: Context) {
    private val db = Ut03Ex02Database.getInstance(applicationContext)

    init {
        Thread{
            db.clearAllTables()
            Thread.sleep(2000)
        }.start()
    }

    /*fun findAll(): List<PersonModel> {
        val people = db.personDao().findAll()
        return mutableListOf()//people.map { peopleEntity -> peopleEntity.toModel }
    }*/
    /*fun findAll(): List<PersonModel>{
        val peopleAndPet = db.personDao().getPersonAndPets()
        return peopleAndPet?.map { element -> element.toModel() } ?: mutableListOf()
    }*/

    fun findAll(): List<PersonModel>{
        val personAndPetAndCar = db.personDao().getPersonAndPetAndCar()
        return personAndPetAndCar?.map { element -> element }
    }

    fun save(personalModel: PersonModel) {
        db.personDao().insertPersonAndPet(
            PersonEntity(
                personalModel.id,
                personalModel.name,
                personalModel.age,
            ), PetEntity(
                personalModel.petModel.id,
                personalModel.petModel.name,
                personalModel.petModel.age,
                personalModel.id
            )
        )

        /*db.personDao().insert(
            PersonEntity(
                personalModel.id,
                personalModel.name,
                personalModel.age)
        )*/
    }

}
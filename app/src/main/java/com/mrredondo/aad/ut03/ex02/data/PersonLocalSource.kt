package com.mrredondo.aad.ut03.ex02.data

import android.content.Context
import com.mrredondo.aad.ut03.ex02.app.Ut03Ex02Database
import com.mrredondo.aad.ut03.ex02.domain.PersonModel
import kotlin.math.E

class PersonLocalSource(applicationContext: Context) {
    private val db = Ut03Ex02Database.getInstance(applicationContext)

    init {
        Thread {
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

    /*fun findAll(): List<PersonModel>{
        val personAndPetAndCar = db.personDao().getPersonAndPetAndCar()
        return personAndPetAndCar.map { element -> element.toModel()}
    }*/

    fun findAll(): List<PersonModel> {
        val personAndPetAndCarAndJob = db.personDao().getPersonAndPetAndCarAndJob()
        return personAndPetAndCarAndJob.map { element -> element.toModel() }
    }

    fun save(personModel: PersonModel) {
        db.personDao().insertPersonAndPetAndCarAndJob(
            PersonEntity.toEntity(personModel),
            PetEntity.toEntity(personModel.petModel, personModel.id),
            CarEntity.toEntity(personModel.carModel, personModel.id),
            JobEntity.toEntity(personModel.jobModel)
        )
    }

    fun save2way(personModel: PersonModel) {
        db.runInTransaction {
            val personId = db.personDao().insert(PersonEntity.toEntity(personModel))
            db.petDao().insert(PetEntity.toEntity(personModel.petModel, personId.toInt()))
            db.carDao().insert(CarEntity.toEntity(personModel.carModel, personId.toInt()))
            val jobIds = db.jobDao().insert(JobEntity.toEntity(personModel.jobModel))
            db.personJobDao()
                //.insert(jobIds.map { jobId -> PersonJobEntity.toEntity(personId.toInt(), jobId.toInt()) })
        }
    }

}
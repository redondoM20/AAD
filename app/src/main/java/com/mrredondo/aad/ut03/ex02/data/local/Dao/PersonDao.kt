package com.mrredondo.aad.ut03.ex02.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mrredondo.aad.ut03.ex02.data.*

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>

    @Insert
    fun insert(personEntity: PersonEntity): Long

    @Insert
    fun insertPersonAndPet(personEntity: PersonEntity, petEntity: PetEntity)

    @Insert
    fun insertPersonAndPetAndCar(personEntity: PersonEntity, petEntity: PetEntity, carEntity: List<CarEntity>)

    @Insert
    fun insertPersonAndPetAndCarAndJob(personEntity: PersonEntity, petEntity: PetEntity, carEntity: List<CarEntity>, jobEntity: List<JobEntity>)

    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPets(): List<PersonAndPet>

    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPetAndCar(): List<PersonAndPetAndCar>

    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPetAndCarAndJob(): List<PersonAndPetAndCarAndJob>

}

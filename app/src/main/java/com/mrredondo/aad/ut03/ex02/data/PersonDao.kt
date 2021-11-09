package com.mrredondo.aad.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>

    @Insert
    fun insert(personEntity: PersonEntity)

    @Insert
    fun insertPersonAndPet(personEntity: PersonEntity, petEntity: PetEntity)

}

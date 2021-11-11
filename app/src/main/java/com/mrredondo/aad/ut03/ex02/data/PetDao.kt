package com.mrredondo.aad.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetDao {
    /*@Query("SELECT * FROM pet")
    fun findAll(): List<PetEntity>*/

    @Insert
    fun insert(petEntity: PetEntity)
}
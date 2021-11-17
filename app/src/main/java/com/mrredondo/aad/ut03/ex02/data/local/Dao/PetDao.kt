package com.mrredondo.aad.ut03.ex02.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import com.mrredondo.aad.ut03.ex02.data.PetEntity

@Dao
interface PetDao {
    /*@Query("SELECT * FROM pet")
    fun findAll(): List<PetEntity>*/

    @Insert
    fun insert(petEntity: PetEntity)
}
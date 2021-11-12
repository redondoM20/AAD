package com.mrredondo.aad.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CarDao {
    @Insert
    fun insert(carEntity: List<CarEntity>): List<Long>
}
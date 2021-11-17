package com.mrredondo.aad.ut03.ex02.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import com.mrredondo.aad.ut03.ex02.data.CarEntity

@Dao
interface CarDao {
    @Insert
    fun insert(carEntity: List<CarEntity>): List<Long>
}
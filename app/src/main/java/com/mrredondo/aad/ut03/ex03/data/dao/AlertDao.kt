package com.mrredondo.aad.ut03.ex03.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.mrredondo.aad.ut03.ex03.data.local.entities.AlertEntity

@Dao
interface AlertDao {

    @Transaction
    @Query("SELECT * FROM alerts")
    fun findAll(): List<AlertEntity>
}
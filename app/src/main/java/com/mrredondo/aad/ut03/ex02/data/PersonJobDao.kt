package com.mrredondo.aad.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PersonJobDao {
    @Insert
    fun insert(join: List<PersonJobEntity>): List<Long>
}
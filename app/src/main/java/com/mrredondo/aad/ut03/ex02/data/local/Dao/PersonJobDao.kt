package com.mrredondo.aad.ut03.ex02.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import com.mrredondo.aad.ut03.ex02.data.PersonJobEntity

@Dao
interface PersonJobDao {
    @Insert
    fun insert(join: List<PersonJobEntity>): List<Long>
}
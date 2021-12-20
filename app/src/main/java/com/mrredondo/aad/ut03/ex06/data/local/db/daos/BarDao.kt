package com.mrredondo.aad.ut03.ex06.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import com.mrredondo.aad.ut03.ex06.data.local.db.BarEntity

@Dao
interface BarDao {
    @Insert
    fun insert(vararg barEntity: BarEntity)
}
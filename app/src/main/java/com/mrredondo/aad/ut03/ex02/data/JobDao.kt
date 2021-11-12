package com.mrredondo.aad.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface JobDao {
    @Insert
    fun insert(jobEntity: List<JobEntity>): List<Long>
}
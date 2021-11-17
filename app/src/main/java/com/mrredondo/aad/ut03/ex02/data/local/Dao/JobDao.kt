package com.mrredondo.aad.ut03.ex02.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import com.mrredondo.aad.ut03.ex02.data.JobEntity

@Dao
interface JobDao {
    @Insert
    fun insert(jobEntity: List<JobEntity>): List<Long>
}
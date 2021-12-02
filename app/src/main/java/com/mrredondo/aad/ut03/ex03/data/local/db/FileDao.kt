package com.mrredondo.aad.ut03.ex03.data.local.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface FileDao {
    @Insert
    fun insert(fileEntities: List<FileEntity>)
}
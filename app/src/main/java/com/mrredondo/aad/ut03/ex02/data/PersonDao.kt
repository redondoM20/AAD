package com.mrredondo.aad.ut03.ex02.data

import androidx.room.Query

interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>
}
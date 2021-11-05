package com.mrredondo.aad.ut03.ex01.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase(){
    abstract fun userDao(): UserDao
}
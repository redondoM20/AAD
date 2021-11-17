package com.mrredondo.aad.ut03.ex02.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex02.data.*
import com.mrredondo.aad.ut03.ex02.data.local.Dao.*

@Database(entities = [PersonEntity::class, PetEntity::class, CarEntity::class, JobEntity::class, PersonJobEntity::class], version = 1)
abstract class Ut03Ex02Database : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun petDao(): PetDao
    abstract fun carDao(): CarDao
    abstract fun jobDao(): JobDao
    abstract fun personJobDao(): PersonJobDao

    companion object {
        @Volatile
        private var instance: Ut03Ex02Database? = null

        fun getInstance(applicationContext: Context): Ut03Ex02Database {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex02Database {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex02Database::class.java,
                "db-ut03-ex02"
            ).build()
        }
    }

}
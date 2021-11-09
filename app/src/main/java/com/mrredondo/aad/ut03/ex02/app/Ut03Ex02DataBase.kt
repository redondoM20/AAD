package com.mrredondo.aad.ut03.ex02.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex02.data.PersonDao
import com.mrredondo.aad.ut03.ex02.data.PersonEntity
import com.mrredondo.aad.ut03.ex02.data.PetDao

@Database(entities = [PersonEntity::class], version = 1)
abstract class Ut03Ex02Database : RoomDatabase() {
    abstract fun personDao(): PersonDao

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
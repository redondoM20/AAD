package com.mrredondo.aad.ut03.ex03.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex03.data.dao.AlertDao
import com.mrredondo.aad.ut03.ex03.data.local.entities.AlertEntity

@Database(
    entities = [AlertEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex03Database : RoomDatabase() {
    abstract fun alertDao(): AlertDao

    companion object {
        @Volatile
        private var instance: Ut03Ex03Database? = null

        fun getInstance(applicationContext: Context): Ut03Ex03Database{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex03Database{
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex03Database::class.java,
                "db-ut03-ex03"
            ).build()
        }
    }
}
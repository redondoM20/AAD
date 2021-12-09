package com.mrredondo.aad.ut03.ex06.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex06.data.local.db.BarEntity
import com.mrredondo.aad.ut03.ex06.data.local.db.TapaEntity
import com.mrredondo.aad.ut03.ex06.data.local.db.daos.BarDao
import com.mrredondo.aad.ut03.ex06.data.local.db.daos.TapaDao

@Database(
    entities = [TapaEntity::class, BarEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex06Database : RoomDatabase(){
    abstract fun tapaDao(): TapaDao
    abstract fun barDao(): BarDao

    companion object{
        @Volatile
        private var instance: Ut03Ex06Database? = null
        fun getInstance(applicationContext: Context): Ut03Ex06Database{
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex06Database{
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex06Database::class.java,
                "db-ut03-ex06-tapas"
            ).build()
        }
    }
}
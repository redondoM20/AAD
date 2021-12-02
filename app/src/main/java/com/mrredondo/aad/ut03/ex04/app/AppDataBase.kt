package com.mrredondo.aad.ut03.ex04.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex04.data.*

@Database(
    entities = [CustomerEntity::class, ProductEntity::class, InvoiceLineEntity::class, /*InvoiceEntity::class*/],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex03Database : RoomDatabase() {

    abstract fun customerDao(): CustomerDao
    abstract fun productDao(): ProductDao
    /*abstract fun invoiceDao(): InvoiceDao*/

    companion object {
        @Volatile
        private var instance: Ut03Ex03Database? = null

        fun getInstance(applicationContext: Context): Ut03Ex03Database{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(applicationContext).also { instance = it}
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex03Database{
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex03Database::class.java,
                "db-ut03-ex04"
            ).build()
        }
    }
}
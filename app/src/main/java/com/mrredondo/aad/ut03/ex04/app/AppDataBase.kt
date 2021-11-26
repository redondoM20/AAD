package com.mrredondo.aad.ut03.ex04.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex04.data.CustomerEntity
import com.mrredondo.aad.ut03.ex04.data.InvoiceEntity
import com.mrredondo.aad.ut03.ex04.data.InvoiceLineEntity
import com.mrredondo.aad.ut03.ex04.data.ProductEntity

@Database(
    entities = [CustomerEntity::class, ProductEntity::class, InvoiceLineEntity::class, InvoiceEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex03Database : RoomDatabase() {

}
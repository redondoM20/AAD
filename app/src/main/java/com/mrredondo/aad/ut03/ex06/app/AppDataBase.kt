package com.mrredondo.aad.ut03.ex06.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrredondo.aad.ut03.ex06.data.local.db.BarEntity
import com.mrredondo.aad.ut03.ex06.data.local.db.TapaEntity

@Database(
    entities = [TapaEntity::class, BarEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex06Database : RoomDatabase(){
    abstract fun
}
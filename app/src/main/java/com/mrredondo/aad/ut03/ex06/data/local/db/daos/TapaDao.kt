package com.mrredondo.aad.ut03.ex06.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mrredondo.aad.ut03.ex06.data.local.db.BarEntity
import com.mrredondo.aad.ut03.ex06.data.local.db.TapaAndBar
import com.mrredondo.aad.ut03.ex06.data.local.db.TapaEntity

@Dao
interface TapaDao {
    @Transaction
    @Query("SELECT * FROM tapas")
    fun findAll(): List<TapaEntity>

    @Query("SELECT * FROM tapas WHERE id = :tapaId")
    fun findById(tapaId: String): TapaAndBar

    @Insert
    fun insert(tapaEntity: TapaEntity): Long

    @Insert
    fun insertTapaAndBar(
        tapaEntity: TapaEntity,
        barEntity: BarEntity
    )

    @Transaction
    @Query("SELECT * FROM tapas")
    fun getTapaAndBar(): List<TapaAndBar>
}
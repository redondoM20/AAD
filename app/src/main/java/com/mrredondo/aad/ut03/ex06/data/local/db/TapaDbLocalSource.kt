package com.mrredondo.aad.ut03.ex06.data.local.db

import android.content.Context
import com.mrredondo.aad.ut03.ex06.app.Ut03Ex06Database
import com.mrredondo.aad.ut03.ex06.data.local.LocalDataSource
import com.mrredondo.aad.ut03.ex06.domain.TapaModel

class TapaDbLocalSource(private val appContext: Context) : LocalDataSource {

    private val db = Ut03Ex06Database.getInstance(appContext)

    override fun findAll(): Result<List<TapaModel>> {
        val tapaAndBar = db.tapaDao().getTapaAndBar()
        val tapasModel = mutableListOf<TapaModel>()
        tapaAndBar.forEach {
            tapasModel.add(it.tapaEntity.toModel(it.barEntity))
        }
        return Result.success(tapasModel)
    }

    override fun saveAll(tapas: Result<List<TapaModel>>) {
        tapas.mapCatching {
            it.forEach {
                db.tapaDao().insertTapaAndBar(
                    TapaEntity.toEntity(it),
                    BarEntity.toEntity(it.barModel, it.id)
                )
            }
        }
    }

    override fun save(tapa: Result<TapaModel>) {
        tapa.mapCatching {
            db.tapaDao().insertTapaAndBar(
                TapaEntity.toEntity(it),
                BarEntity.toEntity(it.barModel, it.id)
            )
        }
    }

    override fun findById(tapaId: String): Result<TapaModel> {
        return findAll().mapCatching {
            it.first { item -> item.id == tapaId }
        }
    }

}
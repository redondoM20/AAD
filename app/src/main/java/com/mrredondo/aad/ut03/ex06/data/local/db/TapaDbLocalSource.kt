package com.mrredondo.aad.ut03.ex06.data.local.db

import android.content.Context
import com.mrredondo.aad.ut03.ex06.app.Ut03Ex06Database
import com.mrredondo.aad.ut03.ex06.data.local.LocalDataSource
import com.mrredondo.aad.ut03.ex06.domain.BarModel
import com.mrredondo.aad.ut03.ex06.domain.Failure
import com.mrredondo.aad.ut03.ex06.domain.TapaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class TapaDbLocalSource (private val appContext: Context) : LocalDataSource{

    private val db = Ut03Ex06Database.getInstance(appContext)

    override fun findAll(): Result<List<TapaModel>> = withContext(Dispatchers.IO) {
        val tapaAndBar = db.tapaDao().getTapaAndBar()
        var tapasModel = mutableListOf<TapaModel>()
        tapaAndBar.map {
            it.tapaEntity.toModel(it.barEntity)
            tapasModel.add(it.tapaEntity.tapaId.toInt(), it.tapaEntity.toModel(it.barEntity))
        }
        Result.success(tapasModel)
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
        return try {
            val tapas = findAll()
            var tapa = TapaModel("", "", "", 0.0, "", BarModel("", "", ""))
            tapas.mapCatching {
                it.forEach {
                    if (it.id==tapaId){
                        tapa=it
                    }
                }
            }
            Result.success(tapa)
        } catch (ex:Exception){
            Result.failure(Failure.DataError)
        }
    }

}
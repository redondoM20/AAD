package com.mrredondo.aad.ut03.ex06.data.local.xml

import android.content.Context
import com.mrredondo.aad.commons.serializer.JsonSerializer
import com.mrredondo.aad.ut03.ex06.data.local.LocalDataSource
import com.mrredondo.aad.ut03.ex06.domain.BarModel
import com.mrredondo.aad.ut03.ex06.domain.TapaModel

class TapasXmlLocalSource (private val context: Context, private val serializer: JsonSerializer) : LocalDataSource {

    private val nameXmlFile = "ut03_ex06_tapas"
    private val sharedPref = context.getSharedPreferences(nameXmlFile, Context.MODE_PRIVATE)

    override fun findAll(): Result<List<TapaModel>> {
        val tapas: MutableList<TapaModel> = mutableListOf()
        val jsonStrings = sharedPref.all.map { it.value }
        jsonStrings.map { jsonString -> serializer.fromJson(jsonString as String, TapaModel::class.java) }
        return Result.success(tapas.toList())
    }

    override fun saveAll(tapas: Result<List<TapaModel>>) {
        val edit = sharedPref.edit()
        tapas.mapCatching {
            it.forEach {
                edit?.putString(it.id, serializer.toJson(it, TapaModel::class.java))
                edit?.apply()
            }
        }
    }

    override fun save(tapa: Result<TapaModel>) {
        val edit = sharedPref.edit()
        tapa.mapCatching {
            edit?.putString(it.id, serializer.toJson(it, TapaModel::class.java))
            edit?.apply()
        }
    }

    override fun findById(tapaId: String): Result<TapaModel> {
        val jsonModel = sharedPref.getString(tapaId, null)
        var tapa: TapaModel = TapaModel("", "", "", 0.0, "", BarModel("", "", ""))
        if (jsonModel != null){
            tapa = serializer.fromJson(jsonModel, TapaModel::class.java)
        }
        return Result.success(tapa)
    }
}
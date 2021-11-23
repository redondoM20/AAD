package com.mrredondo.aad.ut03.ex03.data.local.xml

import android.content.Context
import com.mrredondo.aad.ut03.ex03.app.serializer.JsonSerializer
import com.mrredondo.aad.ut03.ex03.data.local.AlertLocalSource
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

class AlertXmlLocalSource(private val context: Context, private val serializer: JsonSerializer) :
    AlertLocalSource {

    private val nameXmlFile = "ut03_ex03_alerts"
    private val sharedPref = context.getSharedPreferences(nameXmlFile, Context.MODE_PRIVATE)

    override suspend fun finAll(): List<AlertModel> {
        val alerts: MutableList<AlertModel> = mutableListOf()
        val jsonStrings = sharedPref.all.map { it.value }
        jsonStrings.map { jsonString ->
            serializer.fromJson(
                jsonString as String,
                AlertModel::class.java
            )
        }
        return alerts.toList()
    }

    override fun save(alert: AlertModel) {
        TODO("Not yet implemented")
    }

    override fun save(alerts: List<AlertModel>) {
        TODO("Not yet implemented")
    }

    override fun findById(alertId: String): AlertModel? {
        val jsonModel = sharedPref.getString(alertId, null)
        return if (jsonModel != null) {
            serializer.fromJson(jsonModel, AlertModel::class.java)
        } else {
            null
        }
    }
}
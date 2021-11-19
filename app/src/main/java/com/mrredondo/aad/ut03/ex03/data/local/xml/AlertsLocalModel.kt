package com.mrredondo.aad.ut03.ex03.data.local.xml

import com.mrredondo.aad.ut03.ex03.app.storage.LocalModel
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

class AlertsLocalModel (val alertId:String, val alerts: List<AlertModel>): LocalModel {
    override fun getId(): String = ID

    companion object{
        val ID:String = AlertsLocalModel::class.java.simpleName
    }
}
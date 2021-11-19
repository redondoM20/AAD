package com.mrredondo.aad.ut03.ex03.data.local.xml

import com.mrredondo.aad.ut03.ex03.app.storage.LocalStorage
import com.mrredondo.aad.ut03.ex03.data.local.AlertLocalSource
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

class AlertXmlLocalSource (private val localStorage: LocalStorage<AlertsLocalModel>) :AlertLocalSource{
    override fun finAll(): List<AlertModel> {
        val alerts = localStorage.fetch(AlertsLocalModel.ID, AlertsLocalModel::class.java)
        return alerts?.alerts ?: mutableListOf()
    }

    override fun save(alert: AlertModel) {
        TODO("Not yet implemented")
    }

    override fun save(alerts: List<AlertModel>) {
        TODO("Not yet implemented")
    }

    override fun findById(alertId: String): AlertModel? {
        val alert = localStorage.fetch(alertId, AlertsLocalModel::class.java)
        return alert
    }
}
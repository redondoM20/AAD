package com.mrredondo.aad.ut03.ex03.data

import com.mrredondo.aad.ut03.ex03.app.db.Ut03Ex03Database
import com.mrredondo.aad.ut03.ex03.data.remote.AlertRemoteSource
import com.mrredondo.aad.ut03.ex03.domain.AlertModel
import com.mrredondo.aad.ut03.ex03.domain.AlertRepository

class AlertDataRepository (private val remoteSource: AlertRemoteSource): AlertRepository {

    override fun fetchAll(): List<AlertModel> {
        val alerts = remoteSource.getAlerts()
        return alerts
    }

    override fun fetchById(alertId: String): AlertModel {
        val alert = remoteSource.getAlert(alertId)
        TODO("Not yet implemented")
    }
}
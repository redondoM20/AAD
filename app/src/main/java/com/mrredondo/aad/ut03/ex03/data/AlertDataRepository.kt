package com.mrredondo.aad.ut03.ex03.data

import com.mrredondo.aad.ut03.ex03.app.db.Ut03Ex03Database
import com.mrredondo.aad.ut03.ex03.data.local.AlertLocalSource
import com.mrredondo.aad.ut03.ex03.data.remote.AlertRemoteSource
import com.mrredondo.aad.ut03.ex03.domain.AlertModel
import com.mrredondo.aad.ut03.ex03.domain.AlertRepository

class AlertDataRepository(
    private val localSource: AlertLocalSource,
    private val remoteSource: AlertRemoteSource
) : AlertRepository {

    override fun fetchAll(): List<AlertModel> {
        var  alerts = localSource.finAll()
        if (alerts.isEmpty()){
            alerts = remoteSource.getAlerts()
            localSource.save(alerts)
        }
        return alerts
    }


    override fun fetchById(alertId: String): AlertModel? {
        var alert = localSource.findById(alertId)
        if (alert==null){
            alert = remoteSource.getAlert(alertId)
            if (alert!=null){
                localSource.save(alert)

            }

        }
        return alert
    }
}
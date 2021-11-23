package com.mrredondo.aad.ut03.ex03.data.local.db

import android.content.Context
import com.mrredondo.aad.ut03.ex03.app.db.Ut03Ex03Database
import com.mrredondo.aad.ut03.ex03.data.local.AlertLocalSource
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

class AlertDbLocalSource (private val appContext: Context) : AlertLocalSource{

    private val db = Ut03Ex03Database.getInstance(appContext)

    override suspend fun finAll(): List<AlertModel> {
        val dbAlerts = db.alertDao().findAll()
        return dbAlerts.map { alertEntity -> alertEntity.toModel() }
    }

    override fun save(alert: AlertModel) {
        db.alertDao().insert(AlertEntity.toEntity(alert), alert.files.map { file -> FileEntity.toEntity(alert.id, file) })
    }

    override fun save(alerts: List<AlertModel>) {
        db.runInTransaction {
            alerts.forEach { save(it) }
        }
    }

    override fun findById(alertId: String): AlertModel? {
        val dbAlert = db.alertDao().findById(alertId)
        return dbAlert.toModel()
    }
}
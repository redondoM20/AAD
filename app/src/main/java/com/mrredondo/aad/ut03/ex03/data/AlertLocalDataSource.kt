package com.mrredondo.aad.ut03.ex03.data

import android.content.Context
import com.mrredondo.aad.ut03.ex03.app.db.Ut03Ex03Database
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

class AlertLocalDataSource(applicationContext: Context) {
    private val db = Ut03Ex03Database.getInstance(applicationContext)

    init {
        Thread{
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    fun findAll(): List<AlertModel>{
        val alerts = db.alertDao().findAll()
        return alerts.map { ele -> ele.toModel() }
    }
}
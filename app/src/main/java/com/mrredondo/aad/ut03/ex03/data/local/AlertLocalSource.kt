package com.mrredondo.aad.ut03.ex03.data.local

import com.mrredondo.aad.ut03.ex03.domain.AlertModel

interface AlertLocalSource {
    fun finAll(): List<AlertModel>
    fun save(alert: AlertModel)
    fun save(alerts: List<AlertModel>)
    fun findById(alertId: String): AlertModel?
}
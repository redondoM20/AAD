package com.mrredondo.aad.ut03.ex03.data.remote

import com.mrredondo.aad.ut03.ex03.app.ApiClient
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

class AlertRemoteSource(private val apiClient: ApiClient) {


    fun getAlerts(): List<AlertModel> {
        val alertApiModel = apiClient.getAlerts()
        return alertApiModel.map { alertModel -> alertModel.toDomainModel() }
    }

    fun getAlert(alertId: String): AlertModel? =
        apiClient.getAlert(alertId)?.toDomainModel()
}
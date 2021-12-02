package com.mrredondo.aad.ut03.ex03.data.remote

import com.mrredondo.aad.ut03.ex03.app.api.ApiClient
import com.mrredondo.aad.ut03.ex03.domain.AlertModel


class AlertRemoteSource(private val apiClient: ApiClient) {

    suspend fun getAlerts(): List<AlertModel> {
        val alertApiModel = apiClient.getAlerts()
        return alertApiModel.map { apiModel -> apiModel.toDomainModel() }
    }

    suspend fun getAlert(alertId: String): AlertModel? {
        val alert = apiClient.getAlert(alertId)
        return alert?.toDomainModel()
    }
}
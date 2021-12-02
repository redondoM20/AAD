package com.mrredondo.aad.ut03.ex03.app.api

import com.mrredondo.aad.ut03.ex03.data.remote.AlertApiModel


interface ApiClient {
    suspend fun getAlerts(): List<AlertApiModel>
    suspend fun getAlert(alertId: String): AlertApiModel?
}

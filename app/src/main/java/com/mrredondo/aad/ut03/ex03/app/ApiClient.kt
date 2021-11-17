package com.mrredondo.aad.ut03.ex03.app

import com.mrredondo.aad.ut03.ex03.data.remote.AlertApiModel

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
    fun getAlert(alertId: String): AlertApiModel?
}
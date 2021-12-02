package com.mrredondo.aad.ut03.ex03.data.local.xml

import com.mrredondo.aad.ut03.ex03.domain.AlertModel
import com.mrredondo.aad.ut03.ex03.app.storage.LocalModel


class AlertsLocalModel(
    val index: String,
    val alerts: List<AlertModel>
) : LocalModel {
    override fun getId(): String = index

    companion object {
        val ID: String = AlertsLocalModel::class.java.simpleName
    }
}
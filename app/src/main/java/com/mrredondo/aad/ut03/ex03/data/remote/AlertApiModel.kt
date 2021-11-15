package com.mrredondo.aad.ut03.ex03.data.remote

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String,
    val body: String? = "",
    val source: String? = "",
) {
    fun toDomainModel(): Alert
}
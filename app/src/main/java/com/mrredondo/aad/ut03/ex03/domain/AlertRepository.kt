package com.mrredondo.aad.ut03.ex03.domain


interface AlertRepository {
    suspend fun fetchAll(): List<AlertModel>
    suspend fun fetchById(alertId: String): AlertModel
}
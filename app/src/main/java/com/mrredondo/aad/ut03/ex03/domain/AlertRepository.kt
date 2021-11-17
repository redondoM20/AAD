package com.mrredondo.aad.ut03.ex03.domain

interface AlertRepository {
    fun fetchAll(): List<AlertModel>
    fun fetchById(alertId: String): AlertModel
}


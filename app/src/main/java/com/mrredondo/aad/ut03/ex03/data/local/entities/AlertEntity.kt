package com.mrredondo.aad.ut03.ex03.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrredondo.aad.ut03.ex03.data.local.LocalModel
import com.mrredondo.aad.ut03.ex03.domain.AlertModel
import com.mrredondo.aad.ut03.ex03.domain.FileModel

@Entity(tableName = "alerts")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "id") val alertId: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "summary") val summary: String,
    @ColumnInfo(name = "datePublished") val datePublished: String,
    @ColumnInfo(name = "body") val body: String,
    @ColumnInfo(name = "source") val source: String,
) : LocalModel {
    override fun getId(): String = alertId

    fun toModel() =
        AlertModel(alertId, title, type, summary, datePublished, body, source, mutableListOf())
    companion object{
        fun toEntity(alertModel: AlertModel) = AlertEntity(alertModel.id, alertModel.title, alertModel.type, alertModel.summary, alertModel.datePublished, alertModel.body, alertModel.source)
    }
}
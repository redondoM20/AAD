package com.mrredondo.aad.ut03.ex03.data.local.db

import androidx.room.*
import com.mrredondo.aad.ut03.ex03.domain.AlertModel
import com.mrredondo.aad.ut03.ex03.domain.FileModel

@Entity(tableName = "alerts")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "id") val alertId: String,
    val title: String,
    val type: Int,
    val summary: String,
    @ColumnInfo(name = "date_published") val datePublished: String,
    val body: String,
    val source: String,
) {
    fun toModel(fileEntities: List<FileEntity>) = AlertModel(
        alertId,
        title,
        type,
        summary,
        datePublished,
        body,
        source,
        fileEntities.map { fileEntity -> fileEntity.toDomain() }
    )

    companion object {
        fun toEntity(alertModel: AlertModel) = AlertEntity(alertModel.id,
            alertModel.title,
            alertModel.type,
            alertModel.summary,
            alertModel.datePublished,
            alertModel.body,
            alertModel.source)
    }
}



@Entity(tableName = "files")
data class FileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val fileId: Long?,
    val name: String,
    val url: String,
    @ColumnInfo(name = "alert_id") val alertId: String
) {
    fun toDomain() = FileModel(name, url)

    companion object {
        fun toEntity(alertId: String, fileModel: FileModel) =
            FileEntity(null, fileModel.name, fileModel.url, alertId)
    }
}

data class AlertAndFiles(
    @Embedded val alertEntity: AlertEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "alert_id"
    ) val fileEntities: List<FileEntity>,
) {
    fun toModel() = alertEntity.toModel(fileEntities)
}
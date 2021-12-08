package com.mrredondo.aad.ut03.ex06.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrredondo.aad.ut03.ex06.domain.BarModel
import com.mrredondo.aad.ut03.ex06.domain.TapaModel


@Entity(tableName = "tapa")
data class TapaEntity(
    @PrimaryKey @ColumnInfo(name = "id") val tapaId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "url") val url: String,
) {
    fun toModel(
        barEntity: BarEntity
    ) =
        TapaModel(
            tapaId,
            name,
            description,
            price,
            url,
            barEntity.toModel()
        )

    companion object {
        fun toEntity(tapaModel: TapaModel) =
            TapaEntity(tapaModel.id, tapaModel.name, tapaModel.description, tapaModel.price, tapaModel.urlMainPhoto)
    }
}

@Entity(tableName = "bar")
data class BarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val barId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "tapa_id") val tapaId: String
) {
    fun toModel() = BarModel(tapaId, name, address)

    companion object {
        fun toEntity(barModel: BarModel, tapaId: String) =
            BarEntity(barModel.id, barModel.name, barModel.address, tapaId)
    }
}
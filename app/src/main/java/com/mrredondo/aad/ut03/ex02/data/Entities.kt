package com.mrredondo.aad.ut03.ex02.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrredondo.aad.ut03.ex02.domain.PersonModel

@Entity(tableName = "person")
data class PersonEntity (
    @PrimaryKey @ColumnInfo(name="id") val id:Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name = "age") val age: Int
        ){
    fun toModel(): PersonModel = PersonModel(id, name, age, null)
}
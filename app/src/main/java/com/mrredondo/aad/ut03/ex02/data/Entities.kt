package com.mrredondo.aad.ut03.ex02.data

import androidx.room.*
import com.mrredondo.aad.ut03.ex02.domain.PersonModel
import com.mrredondo.aad.ut03.ex02.domain.PetModel

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,

    ) {
    fun toModel(): PersonModel = PersonModel(id, name, age, null, PetModel(1, "", 1))
}

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "person_id") val personId: Int
) {
    fun toModel(): PetModel = PetModel(id, name, age)
}

data class PersonAndPet(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity
) {
    fun toModel() = PersonModel(personEntity.id, personEntity.name, personEntity.age, "", PetModel(petEntity.id, petEntity.name, petEntity.age))
}
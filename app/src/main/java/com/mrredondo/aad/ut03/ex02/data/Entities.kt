package com.mrredondo.aad.ut03.ex02.data

import androidx.room.*
import com.mrredondo.aad.ut03.ex02.domain.CarModel
import com.mrredondo.aad.ut03.ex02.domain.JobModel
import com.mrredondo.aad.ut03.ex02.domain.PersonModel
import com.mrredondo.aad.ut03.ex02.domain.PetModel

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
) {
    fun toModel(petEntity: PetEntity, carEntity: List<CarEntity>, jobEntity: List<JobEntity>) =
        PersonModel(
            id,
            name,
            age,
            "",
            petEntity.toModel(),
            carEntity.map { it.toModel() }.toMutableList(),
            jobEntity.map { it.toModel() }.toMutableList()
        )

    companion object {
        fun toEntity(personModel: PersonModel) =
            PersonEntity(personModel.id, personModel.name, personModel.age)
    }
}

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "person_id") val personId: Int
) {
    fun toModel() = PetModel(id, name, age)

    companion object {
        fun toEntity(petModel: PetModel, personId: Int) =
            PetEntity(petModel.id, petModel.name, petModel.age, personId)
    }
}

@Entity(tableName = "car")
data class CarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "person_id") val personId: Int
) {
    fun toModel() = CarModel(id, brand, model)

    companion object {
        fun toEntity(carsModel: List<CarModel>, personId: Int) = carsModel.map {
            CarEntity(it.id, it.brand, it.model, personId)
        }
    }
}

@Entity(tableName = "job")
data class JobEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
) {
    fun toModel() = JobModel(id, name)

    companion object {
        fun toEntity(jobsModel: List<JobModel>) = jobsModel.map {
            JobEntity(it.id, it.name)
        }
    }
}

data class PersonAndPet(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity
)

data class PersonAndPetAndCar(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val carEntities: List<CarEntity>,
)

@Entity(tableName = "person_job", primaryKeys = ["person_id", "job_id"])
data class PersonJobEntity(
    @ColumnInfo(name = "person_id") val personId: Int,
    @ColumnInfo(name = "job_id") val jobId: Int
) {
    companion object {
        fun toEntity(personId: Int, jobId: Int) = PersonJobEntity(personId, jobId)
    }
}

data class PersonAndPetAndCarAndJob(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val carEntities: List<CarEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PersonEntity::class,
            parentColumn = "id",
            entityColumn = "id"
        )
    ) val jobEntities: List<JobEntity>,
) {
    fun toModel() = personEntity.toModel(petEntity, carEntities, jobEntities)
}



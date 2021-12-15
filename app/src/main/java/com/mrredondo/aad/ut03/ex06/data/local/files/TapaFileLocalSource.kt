package com.mrredondo.aad.ut03.ex06.data.local.files

import android.content.Context
import com.mrredondo.aad.commons.serializer.JsonSerializer
import com.mrredondo.aad.ut03.ex06.data.local.LocalDataSource
import com.mrredondo.aad.ut03.ex06.domain.BarModel
import com.mrredondo.aad.ut03.ex06.domain.Failure
import com.mrredondo.aad.ut03.ex06.domain.TapaModel
import java.io.File

class TapaFileLocalSource(private val context: Context, private val serializer: JsonSerializer):
    LocalDataSource {

    override fun findAll(): Result<List<TapaModel>> {
        val tapas: MutableList<TapaModel> = mutableListOf()
        val file = getFile()
        file.onSuccess {
            val lines = it.readLines()
            lines.map {
                val tapaModel = serializer.fromJson(it, TapaModel::class.java)
                tapas.add(tapaModel)
            }
        }
        return Result.success(tapas)
    }

    override fun saveAll(tapas: Result<List<TapaModel>>) {
        val file = getFile()
        file.onSuccess { file ->
            tapas.onSuccess {
                it.map {
                    file.appendText(serializer.toJson(it, TapaModel::class.java) + System.lineSeparator())
                }
            }
        }
    }

    override fun save(tapa: Result<TapaModel>) {
        val file = getFile()
        file.onSuccess { file ->
            tapa.onSuccess {
                file.appendText(serializer.toJson(it, TapaModel::class.java))
            }
        }
    }

    override fun findById(tapaId: String): Result<TapaModel> {
        return findAll().mapCatching {
            it.first { item -> item.id == tapaId }
        }
    }


    private fun getFile(): Result<File> {
        return try {
            val file = File(context.filesDir, TAPAS_FILENAME)
            if (!file.exists()){
                file.createNewFile()
            }
            Result.success(file)
        } catch (ex: FileSystemException){
            Result.failure(Failure.FileError)
        }
    }

    companion object {
        const val TAPAS_FILENAME: String = "add_tapas.txt"
    }

}
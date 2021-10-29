package com.mrredondo.aad.ut02.exercise03.data

import androidx.appcompat.app.AppCompatActivity
import com.mrredondo.aad.commons.Serializer
import com.mrredondo.aad.ut02.exercise03.Exercise03Activity
import java.io.File

interface LocalStorage<T : LocalModel> {
    fun save(model: T)
    fun fetch(id: String): T?
}

class FileLocalStorage<T : LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
): LocalStorage<T>{

    private val file = File(activity.filesDir, "aad_ex03.txt")

    override fun save(model: T) {
        file.writeText(serializer.toJson(model))
    }

    override fun fetch(id: String): T? {
        if (file.exists()){
            return serializer.fromJson(file.readText())
        }
        return null
    }

}
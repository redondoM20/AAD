package com.mrredondo.aad.ut02.exercise02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mrredondo.aad.R
import com.mrredondo.aad.commons.Serializer
import java.io.File

interface LocalStorage<T : LocalModel> {
    fun save(model: T)
    fun fetch(id: String): T?
}

class FileLocalStorage<T : LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
    )  : LocalStorage<T> {

    private val file = File(activity.filesDir, "add_ex02.txt")

    override fun save(model: T) {
        file.writeText(serializer.toJson(model))
    }

    override fun fetch(id: String): T? {
        val jsonModel: String = file.readText()
        return serializer.fromJson(jsonModel)
    }

}

class MemLocalStorage<T : LocalModel> : LocalStorage<T> {
    private val memDataStorage = mutableListOf<T>()

    override fun save(model: T) {
        memDataStorage.add(model)
    }

    override fun fetch(id: String): T? = memDataStorage.firstOrNull(){ it.getId().toString() == id }
}

class SharPrefLocalStorage<T : LocalModel>(private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
) : LocalStorage<T> {

    private val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_file_exercise02), Context.MODE_PRIVATE)

    override fun save(model: T) {
        val edit = sharedPref.edit()
        edit?.putString(model.getId().toString(), serializer.toJson(model))
        edit?.apply()
    }

    override fun fetch(id: String): T? {
        val jsonModel = sharedPref.getString(id, "{}")
        return if (jsonModel != null){
            serializer.fromJson(jsonModel)
        }else{
            null
        }
    }

    /*private val gson = Gson()
    private val type = object : TypeToken<TapaLocalModel>() {}.type

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.action_sharpref), Context.MODE_PRIVATE
    )

    override fun save(model: T) {
        val edit = sharedPref.edit()
        edit?.putString(model.getId().toString(), gson.toJson(model))
        edit?.apply()
    }

    override fun fetch(id: String): T? {
        val jsonModel = sharedPref.getString(id, "{}")
        return gson.fromJson(jsonModel, type)
    }*/


}
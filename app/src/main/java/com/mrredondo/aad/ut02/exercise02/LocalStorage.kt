package com.mrredondo.aad.ut02.exercise02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mrredondo.aad.R
import com.mrredondo.aad.commons.serializer.JsonSerializer
import java.io.File

interface LocalStorage<T : LocalModel> {
    fun save(model: T, typeClass: Class<T>)
    fun fetch(id: String, typeClass: Class<T>): T?
}

class FileLocalStorage<T : LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: JsonSerializer
    )  : LocalStorage<T> {

    private val file = File(activity.filesDir, "add_ex02.txt")

    override fun save(model: T, typeClass: Class<T>) {
        file.writeText(serializer.toJson(model, typeClass))
    }

    override fun fetch(id: String, typeClass: Class<T>): T? {
        val jsonModel: String = file.readText()
        return serializer.fromJson(jsonModel, typeClass)
    }

}

class MemLocalStorage<T : LocalModel> : LocalStorage<T> {
    private val memDataStorage = mutableListOf<T>()

    override fun save(model: T, typeClass: Class<T>) {
        memDataStorage.add(model)
    }

    override fun fetch(id: String, typeClass: Class<T>): T? = memDataStorage.firstOrNull(){ it.getId().toString() == id }
}

class SharPrefLocalStorage<T : LocalModel>(private val activity: AppCompatActivity,
    private val serializer: JsonSerializer
) : LocalStorage<T> {

    private val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_file_exercise02), Context.MODE_PRIVATE)

    override fun save(model: T, typeClass: Class<T>) {
        val edit = sharedPref.edit()
        edit?.putString(model.getId().toString(), serializer.toJson(model, typeClass))
        edit?.apply()
    }

    override fun fetch(id: String, typeClass: Class<T>): T? {
        val jsonModel = sharedPref.getString(id, "{}")
        return if (jsonModel != null){
            serializer.fromJson(jsonModel, typeClass)
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
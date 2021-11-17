package com.mrredondo.aad.ut03.ex03.data.local

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mrredondo.aad.R
import com.mrredondo.aad.ut03.ex03.domain.AlertModel

interface LocalStorage<T : AlertModel> {
    fun save(model: List<T>)
    fun fetchAll(): List<AlertModel>?
}

class SharPrefDataSource<T : AlertModel>(private val context: AppCompatActivity) : LocalStorage<T> {
    private val gson = Gson()
    private val type = object : TypeToken<AlertModel>() {}.type

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_encrypt_file_key), Context.MODE_PRIVATE
    )

    override fun save(model: List<T>) {
        val edit = sharedPref.edit()
        model .forEach {
            edit?.putString(it.id, gson.toJson(it))
        }
        edit?.apply()
    }

    override fun fetchAll(): List<AlertModel>? {
        val allModels: MutableList<T> = mutableListOf()

        sharedPref.all?.values?.forEach{
            allModels.add(gson.fromJson(it as String, type))
        }
        return allModels.toList()
    }
}
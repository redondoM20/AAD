package com.mrredondo.aad.ut03.ex03.data.local

import android.content.Context
import com.mrredondo.aad.ut03.ex03.app.db.Ut03Ex03Database

class DbLocalStorage<T: Any>(private val context: Context) : LocalStorage<T> {

    private val db: Ut03Ex03Database by lazy {
        Ut03Ex03Database.getInstance(context)
    }

    override fun save(model: List<T>) {
        TODO("Not yet implemented")
    }

    override fun fetch(id: String): T {
        TODO("Not yet implemented")
    }

    override fun fetchAll(): List<T> {
        //return db.alertDao().findAll()
        TODO("Not yet implemented")
    }


}
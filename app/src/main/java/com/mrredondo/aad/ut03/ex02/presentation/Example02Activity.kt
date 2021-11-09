package com.mrredondo.aad.ut03.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mrredondo.aad.R
import com.mrredondo.aad.ut03.ex02.data.PersonDataRepository
import com.mrredondo.aad.ut03.ex02.data.PersonLocalSource
import com.mrredondo.aad.ut03.ex02.domain.PersonModel
import com.mrredondo.aad.ut03.ex02.domain.PersonRepository
import com.mrredondo.aad.ut03.ex02.domain.PetModel

class Example02Activity : AppCompatActivity() {

    private val TAG = Example02Activity::class.java.simpleName

    private val repository: PersonRepository by lazy {
        PersonDataRepository(PersonLocalSource(applicationContext))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        executeQuery()
    }

    private fun executeQuery() {
        Thread {
            repository.savePerson(PersonModel(1, "Name01", 1, "1", PetModel(1, "Petname", 1)))
            val people = repository.fetchAll()
            Log.d(TAG, "$people")
        }.start()
    }

}
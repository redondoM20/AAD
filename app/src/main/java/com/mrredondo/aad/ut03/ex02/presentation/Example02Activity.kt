package com.mrredondo.aad.ut03.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mrredondo.aad.R
import com.mrredondo.aad.ut03.ex02.data.PersonDataRepository
import com.mrredondo.aad.ut03.ex02.data.local.PersonLocalSource
import com.mrredondo.aad.ut03.ex02.domain.*

class Example02Activity : AppCompatActivity() {

    private val TAG = Example02Activity::class.java.simpleName

    private val viewModel by viewModels<Ut03Ex01ViewModel>()

    private val repository: PersonRepository by lazy {
        PersonDataRepository(PersonLocalSource(applicationContext))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        //executeQuery()
        Ut03Ex01Coroutines()
    }

    private fun executeQuery() {
        Thread {
            repository.savePerson(
                PersonModel(
                    1,
                    "Name01",
                    1,
                    "1",
                    PetModel(1, "Petname1", 1),
                    mutableListOf(
                        CarModel(1, "Opel", "Zafira"),
                        CarModel(2, "Ford", "Smax")
                    ),
                    mutableListOf(
                        JobModel(1, "Profesor"),
                        JobModel(2, "Electricista")
                    )
                )
            )
            val people = repository.fetchAll()
            Log.d(TAG, "$people")
        }.start()
    }

    private fun Ut03Ex01Coroutines(){
        viewModel.getPersonsViewModelScope(applicationContext)
    }

}
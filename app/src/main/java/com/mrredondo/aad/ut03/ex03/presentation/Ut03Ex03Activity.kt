package com.mrredondo.aad.ut03.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mrredondo.aad.R
import com.mrredondo.aad.ut02.exercise03.Exercise03Activity
import com.mrredondo.aad.ut03.ex03.data.local.db.AlertDbLocalSource
import kotlin.concurrent.thread

class Ut03Ex03Activity : AppCompatActivity() {

    private val viewModel: Ut03Ex03ViewModel by lazy {
        AlertViewModelFactory.build(AlertDbLocalSource(applicationContext))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
        getAllAlerts()
    }

    private fun getAllAlerts(){
        Thread {
            val alerts = viewModel.getAlerts()
            Log.d("@dev", "$alerts")
        }.start()
        //..Visualizar la información en un LOG.
        // ¿Te atreves con un RecyclerView?
    }

    private fun getAlertById(alertId:String){
        val alertId = alertId
        val alerts = viewModel.findAlert(alertId)
        // ¿Te atreves con un RecyclerView?
    }
}
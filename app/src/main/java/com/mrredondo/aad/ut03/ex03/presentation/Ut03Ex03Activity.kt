package com.mrredondo.aad.ut03.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mrredondo.aad.R
import com.mrredondo.aad.ut02.exercise03.Exercise03Activity

class Ut03Ex03Activity : AppCompatActivity() {

    private val TAG: String = Exercise03Activity::class.java.simpleName
    private val viewModel: Ut03Ex03ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
    }

    private fun getAllAlerts(){
        val alerts = viewModel.getAlerts()
        //..Visualizar la información en un LOG.
        // ¿Te atreves con un RecyclerView?
    }

    private fun getAlertById(){
        val alertId = ""
        val alerts = viewModel.findAlert(alertId)
        // ¿Te atreves con un RecyclerView?
    }
}
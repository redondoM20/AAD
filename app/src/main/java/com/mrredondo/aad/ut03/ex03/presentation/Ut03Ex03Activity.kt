package com.mrredondo.aad.ut03.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.mrredondo.aad.R
import com.mrredondo.aad.databinding.ActivityUt03Ex03Binding
import com.mrredondo.aad.ut03.ex03.app.serializer.GsonSerializer
import com.mrredondo.aad.ut03.ex03.data.local.xml.AlertXmlLocalSource

class Ut03Ex03Activity : AppCompatActivity() {

    /*private val viewModel: Ut03Ex03ViewModel by lazy {
        AlertViewModelFactory.build(AlertDbLocalSource(applicationContext))
    }*/

    private val viewModel: Ut03Ex03ViewModel by lazy {
        AlertViewModelFactory.build(AlertXmlLocalSource(applicationContext, GsonSerializer(Gson())))
    }

    private val binding: ActivityUt03Ex03Binding by lazy {
        ActivityUt03Ex03Binding.inflate(layoutInflater)
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

        // ¿Te atreves con un RecyclerView?
    }
}
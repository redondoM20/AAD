package com.mrredondo.aad.ut03.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.mrredondo.aad.commons.serializer.GsonSerializer
import com.mrredondo.aad.databinding.ActivityUt03Ex06Binding
import com.mrredondo.aad.ut03.ex06.data.local.db.TapaDbLocalSource
import com.mrredondo.aad.ut03.ex06.data.local.files.TapaFileLocalSource
import com.mrredondo.aad.ut03.ex06.data.local.xml.TapasXmlLocalSource

class Ut03Ex06Activity : AppCompatActivity() {

    /*private val viewModel: Ut03Ex06ViewModel by lazy {
        TapaViewFactory.build(TapaFileLocalSource(applicationContext, GsonSerializer(Gson())))
    }*/

    private val viewModel: Ut03Ex06ViewModel by lazy {
        TapaViewFactory.build(TapasXmlLocalSource(applicationContext, GsonSerializer(Gson())))
    }

    /*private val viewModel: Ut03Ex06ViewModel by lazy {
        TapaViewFactory.build(TapaDbLocalSource(applicationContext))
    }*/

    private val bind: ActivityUt03Ex06Binding by lazy {
        ActivityUt03Ex06Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        loadTapas()
        loadTapa("2")
    }

    private fun setupBinding(){
        setContentView(bind.root)
    }

    private fun loadTapas(){
        viewModel.getTapas()
    }

    private fun loadTapa(tapaId: String){
        viewModel.findTapaById(tapaId)
    }
}
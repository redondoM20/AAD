package com.mrredondo.aad.ut03.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mrredondo.aad.R

class Ut03Ex06Activity : AppCompatActivity() {

    private val TAG = Ut03Ex06Activity::class.java.simpleName

    val viewModel = Ut03Ex06ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex06)
        init()
    }

    private fun init(){
        loadTapas()
        loadTapa()
    }

    private fun loadTapas(){
        Thread{
            renderUiTapas(viewModel.loadTapas())
        }.start()
    }

    private fun loadTapa(){
        Thread{
            renderUiTapa(viewModel.loadTapa("123"))
        }
    }

    private fun renderUiTapas(tapasViewState: TapasViewState){
        tapasViewState.tapaModels?.let {
            Log.d(TAG, "Tapas: $it")
        }
        tapasViewState.failure?.let {
            Log.d(TAG, "Error: $it")
        }
    }

    private fun renderUiTapa(tapaViewState: TapaViewState){
        tapaViewState.tapaModels?.let {
            Log.d(TAG, "Tapas: $it")
        }
        tapaViewState.failure?.let {
            Log.d(TAG, "Error: $it")
        }
    }
}
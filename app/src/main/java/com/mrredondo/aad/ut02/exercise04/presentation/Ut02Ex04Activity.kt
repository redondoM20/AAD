package com.mrredondo.aad.ut02.exercise04.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.jmperezra.aad_playground.ut02.ex04.CustomerSharPrefLocalSource
import com.mrredondo.aad.R
import com.mrredondo.aad.commons.serializer.GsonSerializer

class Ut02Ex04Activity : AppCompatActivity() {

    private val localSource: CustomerSharPrefLocalSource by lazy {
        CustomerSharPrefLocalSource(this, GsonSerializer(Gson()), )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut02_ex04)
    }
}
package com.mrredondo.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrredondo.aad.R
import com.mrredondo.aad.ut01.ex02.data.CustomerFileLocalSource
import com.mrredondo.aad.ut01.ex02.domain.CustomRepository
import com.mrredondo.aad_playground.ut01.ex02.CustomerModel

class Ut01Ex02Activity : AppCompatActivity() {

    private val TAG = Ut01Ex02Activity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex02)

    }

    private fun runRepository(){
        val dataSource = CustomerFileLocalSource
        val repository = CustomRepository(dataSource)
        repository.save(
            mutableListOf(
                CustomerModel(1, "name1", "surname1"),
                CustomerModel(2, "name2", "surname2")
            )
        )
    }

}
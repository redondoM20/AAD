package com.mrredondo.aad.ut01.ex02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrredondo.aad.R
import com.mrredondo.aad_playground.ut01.ex02.CustomerFileLocalSource
import com.mrredondo.aad_playground.ut01.ex02.CustomerModel

class Ut01Ex02Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex02)
        getCustomer(CustomerFileLocalSource())
    }

    private fun getCustomer(localSource: CustomerFileLocalSource){
        localSource.save(CustomerModel(1, "name01", "surname01"))
    }
}
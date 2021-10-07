package com.mrredondo.aad.ut02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrredondo.aad.R

class LocalDataSource( private val context: AppCompatActivity) {

    private val sharedPref = context.getSharedPreferences(
        "ut02_shared_pref", Context.MODE_PRIVATE
    )

    val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()


}
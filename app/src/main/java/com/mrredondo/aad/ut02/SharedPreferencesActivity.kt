package com.mrredondo.aad.ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mrredondo.aad.R

class SharedPreferencesActivity : AppCompatActivity() {

    private val TAG = SharedPreferencesActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        initExample01()
        initExample02()
        initExample03()
        initExample04()
    }

    private fun initExample01() {
        val localDataSource = LocalDataSource(this)
        localDataSource.saveAsync("1", "Hola1")
        val data = localDataSource.read("1")
        Log.d(TAG, data!!)
    }

    private fun initExample02() {
        val localDataSource = LocalDataSource(this)
        localDataSource.saveAsyncEncrypt("1", "Hola2")
        val data = localDataSource.readEncrypt("1")
        Log.d(TAG, data!!)
    }

    private fun initExample03(){
        val localDataSource = LocalDataSource(this)
        localDataSource.shortSaveAsync("2", "Adios1")
        val data = localDataSource.read("2")
        Log.d(TAG, data!!)
    }

    private fun initExample04(){
        val localDataSource = LocalDataSource(this)
        localDataSource.saveSyncEncrypt("2", "Adios2")
        val  data = localDataSource.readEncrypt("2")
        Log.d(TAG, data!!)
    }
}
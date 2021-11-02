package com.mrredondo.aad.ut02

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.mrredondo.aad.R

class LocalDataSource( private val context: AppCompatActivity) {

    private val sharedPref = context.getSharedPreferences(
        "ut02_shared_pref", Context.MODE_PRIVATE
    )

    val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptSharedPref = EncryptedSharedPreferences.create(
        context,
        context.getString(R.string.preference_encrypt_file_key),
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    @SuppressLint("CommitPrefEdits")
    fun  saveAsync(key: String, data: String){
        val edit = sharedPref.edit()
        edit?.putString(key, data)
        edit?.commit()
    }

    fun shortSaveAsync(key: String, data: String) {
        with(sharedPref.edit()) {
            putString(key, data)
            apply()
        }
    }

    fun read(key: String): String? {
        return sharedPref.getString(key, "valor_por_defecto")
    }

    @SuppressLint("CommitPrefEdits")
    fun saveAsyncEncrypt(key: String, data: String) {
        val edit = encryptSharedPref.edit()
        edit?.putString(key, data)
        edit?.apply()
    }

    @SuppressLint("CommitPrefEdits")
    fun saveSyncEncrypt(key: String, data: String) {
        val edit = encryptSharedPref.edit()
        edit?.putString(key, data)
        edit?.commit()
    }

    fun readEncrypt(key: String): String? {
        return encryptSharedPref.getString(key, "valor_por_defecto")
    }
}
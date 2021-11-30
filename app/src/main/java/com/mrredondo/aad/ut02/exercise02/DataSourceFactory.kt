package com.mrredondo.aad.ut02.exercise02

import androidx.appcompat.app.AppCompatActivity
import com.mrredondo.aad.R
import com.mrredondo.aad.commons.serializer.JsonSerializer

class DataSourceFactory<T : LocalModel> (
    private val activity: AppCompatActivity,
    private val serializer: JsonSerializer
    ){

    fun create(idActionClicked: Int): LocalStorage<T> {
        return when (idActionClicked) {
            R.id.action_repository_file -> FileLocalStorage(activity, serializer)
            R.id.action_repository_sharpref -> SharPrefLocalStorage(activity, serializer)
            else -> MemLocalStorage()
        }
    }
}
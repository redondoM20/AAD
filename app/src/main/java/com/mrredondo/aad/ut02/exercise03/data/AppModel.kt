package com.mrredondo.aad.ut02.exercise03.data

interface LocalModel{
    fun getId(): Int
}

data class AppModel(val appId: Int = 1, val isFirstTime: Boolean = false) : LocalModel{
    override fun getId(): Int = appId
    fun getFirstTime(): Boolean = isFirstTime
}
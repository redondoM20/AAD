package com.mrredondo.aad.ut02.exercise03.data

interface LocalModel{
    fun getId(): String
}

data class AppModel(val isFirstTime: Boolean = false, val valorStarts: Float = 0f) : LocalModel{
    override fun getId(): String = ID
    /**
     * Método estático, se puede acceder desde fuera.
     */
    companion object {
        val ID = AppModel::class.java.simpleName
    }
}
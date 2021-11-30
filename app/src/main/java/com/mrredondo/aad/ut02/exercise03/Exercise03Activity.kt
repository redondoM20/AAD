package com.mrredondo.aad.ut02.exercise03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import com.google.gson.Gson
import com.mrredondo.aad.R
import com.mrredondo.aad.commons.serializer.GsonSerializer
import com.mrredondo.aad.ut02.exercise03.data.AppModel
import com.mrredondo.aad.ut02.exercise03.data.AppRepository
import com.mrredondo.aad.ut02.exercise03.data.FileLocalStorage

class Exercise03Activity : AppCompatActivity() {

    private val TAG = Exercise03Activity::class.java.simpleName
    private lateinit var appRatingBar: RatingBar
    private lateinit var appRepository: AppRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise03)
        appRepository = AppRepository(FileLocalStorage(this, GsonSerializer(Gson())))
        setupView()
        isFirstTime()
        setRatingValue()
    }

    private fun setupView() {
        findViewById<Button>(R.id.action_reset).setOnClickListener {
            actionResetClicked()
        }
        appRatingBar = findViewById(R.id.action_rating)
        appRatingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            kotlin.run {
                if (fromUser) {
                    onChangeRating(rating)
                }
            }
        }
    }

    private fun isFirstTime() {
        val app = appRepository.fetch()
        if(app == null || app.isFirstTime){
            appRepository.save(AppModel(false))
            Log.i(TAG, "Primera vez")
        } else {
            Log.i(TAG, "No primera vez")
        }
    }

    private fun actionResetClicked() {
        val app = appRepository.fetch()
        if (app != null){
            val resetStarts = 0f
            appRepository.save(AppModel(app.isFirstTime, resetStarts))
            appRatingBar.rating = resetStarts
        }
    }

    private fun onChangeRating(newValue: Float) {
        Log.d(TAG, "El usuario está cambiando el valor: $newValue")
        val app = appRepository.fetch()
        if (app != null){
            appRepository.save(AppModel(app.isFirstTime, newValue))
        }else{
            appRepository.save(AppModel(valorStarts = newValue))
        }
    }

    private fun setRatingValue() {
        val app = appRepository.fetch()
        var newValue = 0f  //Obtener valor de repositorio
        if (app != null){
            newValue = app.valorStarts
        }
        appRatingBar.rating = newValue
    }
}
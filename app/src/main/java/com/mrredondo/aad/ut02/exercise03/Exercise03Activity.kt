package com.mrredondo.aad.ut02.exercise03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import com.mrredondo.aad.R
import com.mrredondo.aad.commons.GsonSerializer
import com.mrredondo.aad.ut02.exercise03.data.AppModel
import com.mrredondo.aad.ut02.exercise03.data.AppRepository
import com.mrredondo.aad.ut02.exercise03.data.FileLocalStorage

class Exercise03Activity : AppCompatActivity() {

    private val TAG = Exercise03Activity::class.java.simpleName
    private lateinit var appRatingBar: RatingBar
    private val appRepository = AppRepository(FileLocalStorage<AppModel>(this, GsonSerializer<AppModel>()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise03)
        setupView()
        isFirstTime()
        //setRatingValue()
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
        val app = appRepository
        Log.i(TAG, "$app")
    }

    private fun actionResetClicked() {

    }

    private fun onChangeRating(newValue: Float) {
        Log.d(TAG, "El usuario está cambiando el valor: ${newValue.toString()}")
    }

    private fun setRatingValue() {
        val newValue: Float = 0f //Obtener valor de repositorio
        appRatingBar.rating = newValue
    }
}
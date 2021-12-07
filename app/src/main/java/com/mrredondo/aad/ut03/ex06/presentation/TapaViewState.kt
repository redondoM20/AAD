package com.mrredondo.aad.ut03.ex06.presentation

import android.hardware.camera2.CaptureFailure
import com.mrredondo.aad.ut03.ex06.domain.TapaModel

data class TapasViewState(
    val isLoading: Boolean,
    val tapaModels: List<TapaModel>?,
    val failure: Throwable?
)
data class TapaViewState(
    val isLoading: Boolean,
    val tapaModel: TapaModel?,
    val failure: Throwable?
)
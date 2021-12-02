package com.mrredondo.aad.ut03.ex03.app.api


import com.mrredondo.aad.ut03.ex03.data.remote.AlertApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * EndPoints de los servicios que se van a usar.
 * Es requisito de Retrofit crear esta interfaz.
 */
interface ApiEndPoint {
    @GET("alerts")
    suspend fun getAlerts(): Response<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    suspend fun getAlert(@Path("alert_id") alertId: String): Response<ApiResponse<AlertApiModel>>
}
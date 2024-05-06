package com.example.horoscopoapp.data.network

import com.example.horoscopoapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import kotlin.math.sign

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse
}
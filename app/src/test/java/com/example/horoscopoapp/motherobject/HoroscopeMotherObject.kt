package com.example.horoscopoapp.motherobject

import com.example.horoscopoapp.data.network.response.PredictionResponse
import com.example.horoscopoapp.domain.model.HoroscopeInfo

object HoroscopeMotherObject {
    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )

    val anyResponse = PredictionResponse("date", "prediction", "taurus")
}
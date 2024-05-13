package com.example.horoscopoapp.ui.horoscope

import com.example.horoscopoapp.data.provider.HoroscopeProvider
import com.example.horoscopoapp.motherobject.HoroscopeMotherObject
import com.example.horoscopoapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest{

    @MockK()
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel
    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscope are loaded`(){
        every { horoscopeProvider.getHoroscope() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)


        //When
        val horoscopes = viewModel.horoscope.value

        //Then
        assertTrue(horoscopes.isNotEmpty())
    }
}
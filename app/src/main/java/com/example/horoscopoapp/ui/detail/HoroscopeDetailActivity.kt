package com.example.horoscopoapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscopoapp.domain.model.HoroscopeModel
import com.example.horoscopoapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel:HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBakc.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }

    private fun errorState() {
        binding.progressBar.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTitleDetail.text = state.sign
        binding.tvBodyDetail.text = state.prediction

       val image = when(state.horoscopeModel){
            Aries -> R.drawable.aries
            Taurus -> R.drawable.taurus
            Gemini -> R.drawable.gemini
            Cancer -> R.drawable.cancer
            Leo -> R.drawable.leo
            Virgo -> R.drawable.virgo
            Libra -> R.drawable.libra
            Scorpio -> R.drawable.scorpio
            Sagittarius -> R.drawable.sagitario
            Capricorn -> R.drawable.capricornio
            Aquarius -> R.drawable.aquarius
            Pisces -> R.drawable.piscis
        }

        binding.ivDetail.setImageResource(image)
    }
}
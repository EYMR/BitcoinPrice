package com.eymr.bitcoinprice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eymr.bitcoinprice.databinding.ActivityMainBinding
import com.eymr.bitcoinprice.features.BitcoinPriceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : BitcoinPriceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Establecer el ViewModel en el enlace de datos
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Observar el LiveData en el ViewModel para actualizar la interfaz de usuario
        viewModel.uiState.observe(this, Observer { state ->
            // Actualizar la interfaz de usuario según el estado
            binding.priceTextView.text = state
        })

        // Llamar al método bitcoinPrice() en el ViewModel para obtener el precio de Bitcoin
        viewModel.bitcoinPrice()
    }
}



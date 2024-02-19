package com.eymr.bitcoinprice

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eymr.bitcoinprice.databinding.ActivityMainBinding
import com.eymr.bitcoinprice.features.BitcoinPriceViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BitcoinPriceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(BitcoinPriceViewModel::class.java)

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



package com.eymr.bitcoinprice.features

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.eymr.bitcoinprice.R
import com.eymr.bitcoinprice.databinding.FragmentBitcoinPriceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BitcoinPriceFragment : Fragment() {

    private lateinit var binding: FragmentBitcoinPriceBinding
    private val viewModel: BitcoinPriceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBitcoinPriceBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner, Observer { state ->
            binding.priceTextView.text = state
        })
        viewModel.bitcoinPrice()
    }
}

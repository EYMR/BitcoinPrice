package com.eymr.bitcoinprice.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eymr.bitcoinprice.databinding.FragmentBitcoinPriceBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment for displaying Bitcoin price information.
 */
@AndroidEntryPoint
class BitcoinPriceFragment : Fragment() {

    private lateinit var binding: FragmentBitcoinPriceBinding
    private val viewModel: BitcoinPriceViewModel by viewModels()

    /**
     * Creates the view for the fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBitcoinPriceBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}


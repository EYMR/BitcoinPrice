package com.eymr.bitcoinprice.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing Bitcoin price data and UI state.
 *
 * @param bitcoinRepository The repository for retrieving Bitcoin price data.
 */
@HiltViewModel
class BitcoinPriceViewModel @Inject constructor(
    private val bitcoinRepository: IBitcoinRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<Bitcoin>(Bitcoin())
    val uiState: StateFlow<Bitcoin>
        get() = _uiState.asStateFlow()

    /**
     * Initializes the ViewModel by fetching the Bitcoin price data.
     */
    init {
        fetchBitcoinPrice()
    }

    /**
     * Fetches the Bitcoin price data and updates the UI state.
     */
    private fun fetchBitcoinPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            bitcoinRepository.getPrice().collect { response ->
                when(response){
                    is Resource.Failure -> {
                        // Handle failure
                        // response.message
                        // _uiState.update {  Bitcoin() } // Reset state or handle error
                    }
                    is Resource.Success -> {
                        // Update UI state with successful response
                        _uiState.update {  response.data }
                    }
                }
            }
        }
    }
}



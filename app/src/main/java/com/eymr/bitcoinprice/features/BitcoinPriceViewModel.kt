package com.eymr.bitcoinprice.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eymr.bitcoinprice.core.di.IoDispatcher
import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.domain.models.bitcoinprice.BitcoinPrice
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BitcoinPriceViewModel @Inject constructor(
    private val bitcoinRepository: IBitcoinRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState = MutableStateFlow<BitcoinPrice>(BitcoinPrice())
    val uiState: StateFlow<BitcoinPrice>
        get() = _uiState.asStateFlow()

    init {
        fetchBitcoinPrice()
    }
    fun fetchBitcoinPrice() {
        viewModelScope.launch(dispatcher) {
            bitcoinRepository.getPrice().collect { response ->
                when(response){
                    is Resource.Failure -> {
                        _uiState.update {  BitcoinPrice() }
                    }
                    is Resource.Success -> {
                        _uiState.update {  response.data }
                    }
                }
            }
        }
    }
}


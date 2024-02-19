package com.eymr.bitcoinprice.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BitcoinPriceViewModel @Inject constructor(
    private val bitcoinRepository: IBitcoinRepository
) : ViewModel() {
    private val _uiState = MutableLiveData<String>()
    val uiState: LiveData<String> = _uiState

    fun bitcoinPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = bitcoinRepository.getPrice()) {
                is Resource.Failure -> {
                    withContext(Dispatchers.Main) {
                        _uiState.value = "Error"
                    }
                }
                is Resource.Success -> {
                    withContext(Dispatchers.Main) {
                        _uiState.value = "Success"
                    }
                }
            }
        }
    }
}


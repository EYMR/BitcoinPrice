package com.eymr.bitcoinprice.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eymr.bitcoinprice.core.di.IoDispatcher
import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
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

    private val _uiState = MutableStateFlow<Bitcoin>(Bitcoin())
    val uiState: StateFlow<Bitcoin>
        get() = _uiState.asStateFlow()

//    private val _uiState = MutableLiveData<Bitcoin>()
//    val uiState: LiveData<Bitcoin> = _uiState

    init {
        fetchBitcoinPrice()
    }
    fun fetchBitcoinPrice() {
        viewModelScope.launch(dispatcher) {
            bitcoinRepository.getPrice().collect { response ->
                when(response){
                    is Resource.Failure -> {
                        _uiState.update {  Bitcoin() }
                    }
                    is Resource.Success -> {
                        _uiState.update {  response.data }
                    }
                }
            }
        }
    }
}


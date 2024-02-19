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

@HiltViewModel
class BitcoinPriceViewModel @Inject constructor(
    private val bitcoinRepository: IBitcoinRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<Bitcoin>(Bitcoin())
    val uiState: StateFlow<Bitcoin>
        get() = _uiState.asStateFlow()

//    private val _uiState = MutableLiveData<Bitcoin>()
//    val uiState: LiveData<Bitcoin> = _uiState

    init {
        fetchBitcoinPrice()
    }
    private fun fetchBitcoinPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            bitcoinRepository.getPrice().collect { response ->
                when(response){
                    is Resource.Failure -> {
                        //response.message
                        //_uiState.postValue()
                    }
                    is Resource.Success -> {
                        _uiState.update {  response.data }
                    }
                }
            }
        }
    }
}


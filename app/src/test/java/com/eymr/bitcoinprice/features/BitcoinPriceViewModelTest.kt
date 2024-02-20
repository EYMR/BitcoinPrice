package com.eymr.bitcoinprice.features

import com.eymr.bitcoinprice.core.utils.Resource
import com.eymr.bitcoinprice.core.utils.toUI
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bitcoin
import com.eymr.bitcoinprice.domain.models.bitcoinprice.BitcoinPrice
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Bpi
import com.eymr.bitcoinprice.domain.models.bitcoinprice.EUR
import com.eymr.bitcoinprice.domain.models.bitcoinprice.GBP
import com.eymr.bitcoinprice.domain.models.bitcoinprice.Time
import com.eymr.bitcoinprice.domain.models.bitcoinprice.USD
import com.eymr.bitcoinprice.domain.repositories.IBitcoinRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class BitcoinPriceViewModelTest {


    private val mockBitcoinData = Bitcoin(
        time = Time(
            updated = "Feb 20, 2024 01:09:23 UTC",
            updatedISO = "2024-02-20T01:09:23+00:00",
            updateduk = "Feb 20, 2024 at 01:09 GMT"
        ),
        disclaimer = "This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org",
        chartName = "Bitcoin",
        bpi = Bpi(
            USD = USD(
                code = "USD",
                symbol = "&#36;",
                rate = "51,747.938",
                description = "United States Dollar",
                rate_float = 51747.9379
            ),
            GBP = GBP(
                code = "GBP",
                symbol = "&pound;",
                rate = "41,110.425",
                description = "British Pound Sterling",
                rate_float = 41110.4248
            ),
            EUR = EUR(
                code = "EUR",
                symbol = "&euro;",
                rate = "48,049.099",
                description = "Euro",
                rate_float = 48049.0988
            )
        )
    )


    // Subject under test
    private lateinit var viewModel: BitcoinPriceViewModel

    @Test
    fun `test fetchBitcoinPrice success`() = runTest {
        // Given
        val bitcoinRepository = mockk<IBitcoinRepository>()
        val bitcoinData = mockBitcoinData
        val dispatcher = Dispatchers.IO
        val bitcoinDataUI = bitcoinData.toUI()

        coEvery { bitcoinRepository.getPrice() } returns flowOf(Resource.Success(bitcoinDataUI))
        val viewModel = BitcoinPriceViewModel(bitcoinRepository, dispatcher)

        // When
        viewModel.fetchBitcoinPrice()

        // Then
        assertEquals(BitcoinPrice(), viewModel.uiState.value)

        // Cancel the job to release resources
    }


    @Test
    fun `test fetchBitcoinPrice failure`() = runTest {
        // Given
        val bitcoinRepository = mockk<IBitcoinRepository>()
        val error = "Test error"
        val dispatcher = Dispatchers.IO
        coEvery { bitcoinRepository.getPrice() } returns flowOf(Resource.Failure(error))
        viewModel = BitcoinPriceViewModel(bitcoinRepository,dispatcher)

        // When
        viewModel.fetchBitcoinPrice()

        // Then
        assertEquals(viewModel.uiState.value, BitcoinPrice(/* Add default data */))
    }
}
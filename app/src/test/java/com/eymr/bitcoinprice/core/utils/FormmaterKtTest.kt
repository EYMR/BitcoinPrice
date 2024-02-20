package com.eymr.bitcoinprice.core.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `test transformTime`() {
        // Given
        val inputTime = "Feb 20, 2024 01:09:23 UTC"
        val expectedOutputTime = "01:09"

        // When
        val result = transformTime(inputTime)

        // Then
        assertEquals(expectedOutputTime, result)
    }

    @Test
    fun `test transformDate`() {
        // Given
        val inputDate = "Feb 20, 2024 01:09:23 UTC"
        val expectedOutputDate = "20 February 2024"

        // When
        val result = transformDate(inputDate)

        // Then
        assertEquals(expectedOutputDate, result)
    }
}
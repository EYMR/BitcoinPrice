// DateUtils.kt
package com.eymr.bitcoinprice.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

    @RequiresApi(Build.VERSION_CODES.O)
    fun transformTime(time: String): String {
        if (time.isEmpty()) {
            return ""
        }
        val inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale("es", "ES"))
        val dateTime = LocalDateTime.parse(time, inputFormatter)
        return dateTime.format(outputFormatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun transformDate(date: String): String {
        if (date.isEmpty()) {
            return ""
        }
        val inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("en", "USA"))
        val dateTime = LocalDateTime.parse(date, inputFormatter)
        return dateTime.format(outputFormatter)
    }


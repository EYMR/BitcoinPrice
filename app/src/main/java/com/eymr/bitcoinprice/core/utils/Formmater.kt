// DateUtils.kt
package com.eymr.bitcoinprice.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * A utility class for date and time transformations.
 */
object DateUtils {

    /**
     * Transforms a time string into a different format.
     *
     * @param time The input time string in the format "MMM dd, yyyy HH:mm:ss z".
     * @return The transformed time string in the format "HH:mm".
     */
    @RequiresApi(Build.VERSION_CODES.O)
    @JvmStatic
    fun transformTime(time: String): String {
        if (time.isEmpty()) {
            return ""
        }
        val inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale("es", "ES"))
        val dateTime = LocalDateTime.parse(time, inputFormatter)
        return dateTime.format(outputFormatter)
    }

    /**
     * Transforms a date string into a different format.
     *
     * @param date The input date string in the format "MMM dd, yyyy HH:mm:ss z".
     * @return The transformed date string in the format "dd MMMM yyyy".
     */
    @RequiresApi(Build.VERSION_CODES.O)
    @JvmStatic
    fun transformDate(date: String): String {
        if (date.isEmpty()) {
            return ""
        }
        val inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("en", "USA"))
        val dateTime = LocalDateTime.parse(date, inputFormatter)
        return dateTime.format(outputFormatter)
    }
}

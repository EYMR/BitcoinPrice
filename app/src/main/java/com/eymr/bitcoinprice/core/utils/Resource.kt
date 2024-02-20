package com.eymr.bitcoinprice.core.utils

/**
 * A sealed class representing a resource that can either be successful or a failure.
 *
 * @param T The type of data contained in the resource.
 */
sealed class Resource<T> {
    /**
     * Represents a successful resource with the provided data.
     *
     * @param data The data contained in the successful resource.
     */
    data class Success<T>(val data: T) : Resource<T>()

    /**
     * Represents a failed resource with an optional error message and exception.
     *
     * @param message The error message, if any.
     * @param exception The exception that caused the failure, if any.
     */
    data class Failure<T>(
        val message: String?,
        val exception: Throwable? = null
    ) : Resource<T>()
}

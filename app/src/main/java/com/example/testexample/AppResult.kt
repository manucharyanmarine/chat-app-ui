package com.example.testexample

sealed class AppResult<T> {
    data class Success<T>(val result: T) : AppResult<T>()
    data class Failure<T>(val error: Throwable) : AppResult<T>()

    fun successOrNull(): T? = when (this) {
        is Success -> result
        is Failure -> null
    }
}
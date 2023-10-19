package com.salugan.cobakeluar.core.utils

sealed class Result<out R> private constructor() {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out E>(val errorData: E) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
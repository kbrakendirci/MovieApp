package com.example.movieapp

sealed class UseCaseState <T>(val data: T? = null, val message: String? = null) {
        class Loading<T>(data: T? = null) :  UseCaseState<T>(data)
        class Success<T>(data: T?) :  UseCaseState<T>(data)
        class Error<T>(message: String, data: T? = null) :  UseCaseState<T>(data, message)
}
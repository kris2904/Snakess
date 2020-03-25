package com.example.snakess.base

interface IRestClient {
    fun <S> createService(serviceClass: Class<S>): S

    fun cancelAllRequests()
}
package com.example.snakess.domain.repositories.rest.service

import com.example.snakess.domain.di.models.User
import retrofit2.http.Body
import retrofit2.http.PUT
import io.reactivex.Observable
import retrofit2.http.Headers
import retrofit2.http.POST

interface IUserRestApiService {
    /**
     * Регистрация нового профиля пользователя
     */
    @PUT(value="/user/v1/registration")
    fun registration(@Body user: User):Observable<User>
    /**
     * Авторизация пользователя по существующему профилю
     */

    @POST(value="/user/v1/login")
    fun login (@Body user: User):Observable<User>
}
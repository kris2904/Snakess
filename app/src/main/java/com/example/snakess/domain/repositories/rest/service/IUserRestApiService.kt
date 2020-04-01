package com.example.snakess.domain.repositories.rest.service

import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.Token
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface IUserRestApiService {
    /**
     * Регистрация нового профиля пользователя
     */
    @PUT(value = "/user/v1/registration")
    fun registration(@Body user: User): Observable<User>

    /**
     * Авторизация пользователя по существующему профилю
     */

    @POST(value = "/user/v1/login")
    fun login(@Body user: User): Observable<User>

    @POST(value = "/user/v1/refresh")
    fun refreshToken(@Header("refresh_token") refresh_token: String): Call<Token>
}
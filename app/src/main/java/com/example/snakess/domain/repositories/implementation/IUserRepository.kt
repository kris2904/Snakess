package com.example.snakess.domain.repositories.implementation

import com.example.snakess.base.SubRX
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.Token
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.User
import java.net.HttpURLConnection

interface IUserRepository {
    fun getUser():User?
    fun login(observer: SubRX<User>, login:String, pass:String)
    fun refreshToken(token: Token, onRetry: (Int) -> Boolean = { it == HttpURLConnection.HTTP_UNAUTHORIZED }): Token?
    fun registration(observer: SubRX<User>, login: String, pass: String)

}
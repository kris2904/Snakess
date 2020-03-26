package com.example.snakess.domain.repositories.local

import com.example.snakess.domain.di.models.Token
import com.example.snakess.domain.di.models.User

interface IUserStorge {
    fun save(user: User)
    fun dropCredentials()
    fun saveTokens(token: Token)

}
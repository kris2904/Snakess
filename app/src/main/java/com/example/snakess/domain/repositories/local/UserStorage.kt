package com.example.snakess.domain.repositories.local

import com.example.snakess.domain.di.models.Token
import com.example.snakess.domain.di.models.User
import javax.inject.Inject

class UserStorage:IUserStorge {
    var user: User? = null
        private set


    @Inject
    constructor()

    override fun save(user: User) {
        this.user = user
    }

    override fun dropCredentials() {
        user = null
    }

    override fun saveTokens(token: Token) {
        user?.token = token
    }

}
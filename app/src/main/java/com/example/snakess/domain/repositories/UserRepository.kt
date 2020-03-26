package com.example.snakess.domain.repositories

import com.example.snakess.base.SubRX
import com.example.snakess.base.standardSubscribeIO
import com.example.snakess.domain.di.models.Token
import com.example.snakess.domain.di.models.User
import com.example.snakess.domain.repositories.local.UserStorage
import com.example.snakess.domain.repositories.rest.api.UserRestApi
import javax.inject.Inject


class UserRepository {
    private val storage: UserStorage
    private val rest: UserRestApi

    @Inject
    constructor(storage: UserStorage, rest: UserRestApi) {
        this.storage = storage
        this.rest = rest

    }

    fun registration(observer: SubRX<User>, login: String, pass: String) {

        rest.registration(login, pass)
            .doOnNext { storage.save(it) }
            .standardSubscribeIO(observer)
    }

    fun login(observer: SubRX<User>, login: String, pass: String) {

        rest.login(login, pass)
            .doOnNext { storage.save(it) }
            .standardSubscribeIO(observer)
    }

    fun getUser() = storage.user

    /* fun refreshToken(observer: SubRX<Token>,access:String,refresh:String) {
         rest.refreshToken(access,refresh)
             .doOnNext()
             .standardSubscribeIO()
     }*/
    fun refreshToken(token: Token): Token {
       TODO()
    }
   /* fun refreshToken(observer: SubRX<Token>, refresh: String)  {
        rest.refreshToken(refresh)
            .doOnNext {
                storage.sTokens(it)
            }
            .map {
                return@map Token(it.access,it.refresh)
            }
            .standardSubscribeIO(observer)
    }*/

    fun fetchUser() {

    }

}
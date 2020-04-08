package com.example.snakess.domain.repositories

import android.os.SystemClock
import com.example.snakess.base.SubRX
import com.example.snakess.base.standardSubscribeIO
import com.example.snakess.domain.repositories.implementation.IUserRepository
import com.example.snakess.domain.repositories.local.UserStorage
import com.example.snakess.domain.repositories.rest.api.UserRestApi
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.Token
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.User
import java.net.HttpURLConnection
import javax.inject.Inject


class UserRepository: IUserRepository {
    private val storage: UserStorage
    private val rest: UserRestApi

    @Inject
    constructor(storage: UserStorage, rest: UserRestApi) {
        this.storage = storage
        this.rest = rest

    }

    override fun registration(observer: SubRX<User>, login: String, pass: String) {

        rest.registration(login, pass)
            .doOnNext { storage.save(it) }
            .standardSubscribeIO(observer)
    }

    override fun login(observer: SubRX<User>, login: String, pass: String) {

        rest.login(login, pass)
            .doOnNext { storage.save(it) }
            .standardSubscribeIO(observer)
    }

    override fun getUser() = storage.getUser()

    override fun refreshToken(token: Token, onRetry: (Int) -> Boolean): Token? {

        val response = rest.refreshToken(token.refresh).execute()
        response.body()?.let {
            storage.saveTokens(it)
            return it
        }

        if (onRetry(response.code())) {
            SystemClock.sleep(500)
            return refreshToken(token)
        }

        return null
    }

}
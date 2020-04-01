package com.example.snakess.domain.repositories.local


import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.Token
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.User

interface IUserStorge {
    fun save(user: User)
    fun dropCredentials()
    fun saveTokens(token: Token)
    fun getUser(): User?

}
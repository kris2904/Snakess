package com.example.snakess.domain.repositories

import com.example.snakess.domain.models.User

class UserRepository {
    fun registration(subscriber: (String) -> Unit, login: String, pass: String) {
        subscriber.invoke("$login : $pass")
    }
    fun authorization (subscriber: (String) -> Unit, login: String, pass: String) {
        subscriber.invoke("$login : $pass")
    }
     fun fetchUser():User{
        Thread.sleep(300)
        val mockData = User(login = "ilina", pass = "123")
        return mockData
    }

}
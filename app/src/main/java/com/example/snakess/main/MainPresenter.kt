package com.example.snakess.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.models.User
import com.example.snakess.domain.repositories.UserRepository

@InjectViewState
class MainPresenter : MvpPresenter<IMainView>() {
    private var userRepository = UserRepository()

    fun checkAuth(): Boolean {
        //Проверка, если в БД есть пользователь
        val userFromBD = userRepository.fetchUser()
        if(userFromBD != null){
            return true
        }else{
            return false
        }
    }
}
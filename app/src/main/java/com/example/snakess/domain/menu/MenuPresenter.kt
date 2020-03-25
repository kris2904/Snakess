package com.example.snakess.domain.menu

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.repositories.UserRepository

@InjectViewState
class MenuPresenter : MvpPresenter<IMenuView>() {
   // private var userRepository = UserRepository

    /*fun checkAuth(): Boolean {
        //Проверка, если в БД есть пользователь
        val userFromBD = userRepository.fetchUser()
        if(userFromBD != null){
            return true
        }else{
            return false
        }
    }*/
}
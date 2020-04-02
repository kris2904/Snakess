package com.example.snakess.presention.credentials.menu

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MenuPresenter : MvpPresenter<IMenuView>{
    @Inject
    constructor()
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
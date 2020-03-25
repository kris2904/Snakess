package com.example.snakess.presention.credentials.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.activitys.LoginActivity.Companion.show
import com.example.snakess.activitys.MainActivity
import com.example.snakess.base.SubRX
import com.example.snakess.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class AuthPresentor:MvpPresenter<IAurhView> {
    @Inject
    lateinit var userRepository :UserRepository
    @Inject
    constructor()

    fun authtorization(login: String, psss:String){
        viewState.lock()
        userRepository.login(SubRX { _, e ->
            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }
            MainActivity.show()

        },login,psss)
        if(!checkAuth()) viewState.unlock()

    }
     fun checkAuth():Boolean {
        val userFromBD = userRepository.fetchUser()
        if (userFromBD != null) {
            return true
            //viewState.showMenuFragment()
        } else {
            return false
            //viewState.showAuthActivity()
        }
    }

 fun showError(){

 }
}
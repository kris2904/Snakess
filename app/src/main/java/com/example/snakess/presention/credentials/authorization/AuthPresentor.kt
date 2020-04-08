package com.example.snakess.presention.credentials.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.activitys.MenuActivity
import com.example.snakess.base.SubRX
import com.example.snakess.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class AuthPresentor:MvpPresenter<IAurhView> {
    //@Inject
    private var userRepository :UserRepository
    @Inject
    constructor(userRepository :UserRepository){
        this.userRepository=userRepository
    }

    fun authtorization(login: String, psss:String){
        viewState.lock()
        userRepository.login(SubRX { _, e ->
            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }
            MenuActivity.show()
        },login,psss)

    }

}
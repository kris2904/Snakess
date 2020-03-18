package com.example.snakess.authorization

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.models.User
import com.example.snakess.domain.repositories.UserRepository
import com.example.snakess.registration.RegistrationPresenter

@InjectViewState
class AuthPresentor:MvpPresenter<IAurhView>() {
    private var userRepository = UserRepository()

    fun fetchUser() {
        viewState.loading()

    }

    fun registration(login: String, psss:String){

        userRepository.registration({
            if(login.isEmpty())
                viewState.showError(text = "поле логин не заполнено")
            if (psss.isEmpty())
                viewState.showError(text = "Поле пароль незаполнено")
        },login,psss)

    }

}
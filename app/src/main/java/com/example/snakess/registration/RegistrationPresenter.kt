package com.example.snakess.registration

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.models.User
import com.example.snakess.domain.repositories.UserRepository
import kotlin.concurrent.thread

@InjectViewState
class RegistrationPresenter: MvpPresenter<IRegistrationView>() {


   private var userRepository = UserRepository()

    fun fetchUser() {
        viewState.loading()

    }

    fun registration(login:String,psss:String){
        userRepository.registration({
            if(login.isEmpty())
                viewState.showError(text = "поле логин не заполнено")
            if (psss.isEmpty())
                viewState.showError(text = "Поле пароль незаполнено")
        },login,psss)

    }



}
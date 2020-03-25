package com.example.snakess.presention.credentials.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.activitys.MainActivity
import com.example.snakess.base.SubRX
import com.example.snakess.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter: MvpPresenter<IRegistrationView> {

@Inject
lateinit var userRepository : UserRepository
    @Inject
    constructor()

/*    fun fetchUser() {
        viewState.loading()

    }*/
    fun registration(login:String,psss:String){
        viewState.lock()
        userRepository.registration(SubRX { _, e ->
            viewState.unlock()

            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }

            MainActivity.show()

        },login,psss)

    }




}
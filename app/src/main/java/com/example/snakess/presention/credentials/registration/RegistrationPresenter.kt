package com.example.snakess.presention.credentials.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.activitys.MenuActivity
import com.example.snakess.base.SubRX
import com.example.snakess.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter: MvpPresenter<IRegistrationView> {

   // @Inject
   private var userRepository: UserRepository

    @Inject
    constructor(userRepository: UserRepository){
        this.userRepository=userRepository
    }

    fun registration(login: String, psss: String) {
        viewState.lock()
        userRepository.registration(SubRX { _, e ->
            viewState.unlock()

            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }
            MenuActivity.show()

        }, login, psss)

    }
}
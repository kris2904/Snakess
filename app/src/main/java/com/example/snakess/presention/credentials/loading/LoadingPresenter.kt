package com.example.snakess.presention.credentials.loading

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class LoadingPresenter : MvpPresenter<ILoaderView> {
    @Inject
    constructor()
   /* @Inject
    private var userRepository = UserRepository()*/

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
       // checkAuth()
      loadStaticResources()
    }

    /*private fun checkAuth():Boolean {
        val userFromBD = userRepository.fetchUser()
        if (userFromBD != null) {
            return true
            //viewState.showMenuFragment()
        } else {
            return false
            //viewState.showAuthActivity()
        }
    }*/

fun loadStaticResources() {
    Handler().postDelayed({

        viewState.onLoadingComplete()

    }, 2000)
}
}
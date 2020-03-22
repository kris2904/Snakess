package com.example.snakess.main.loading

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.repositories.UserRepository

@InjectViewState
class LoadingPresenter : MvpPresenter<ILoaderView>() {
    private var userRepository = UserRepository()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        checkAuth()
    }

    private fun checkAuth() {
        viewState.showLoading()
        val userFromBD = userRepository.fetchUser()
        if (userFromBD != null) {
            viewState.showMenuFragment()
        } else {
            viewState.showAuthActivity()
        }
        viewState.hideLoading()
    }
}
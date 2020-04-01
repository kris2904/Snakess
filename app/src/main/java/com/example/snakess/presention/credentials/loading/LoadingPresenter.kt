package com.example.snakess.presention.credentials.loading

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.activitys.MenuActivity
import com.example.snakess.domain.repositories.UserRepository
import javax.inject.Inject

@InjectViewState
class LoadingPresenter : MvpPresenter<ILoaderView> {

    private val userRepository:UserRepository

    @Inject
    constructor(userRepository: UserRepository){
        this.userRepository=userRepository
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
      loadStaticResources()
    }


fun loadStaticResources() {
    Handler().postDelayed({
        val user =userRepository.getUser()
        if(user!=null){
            MenuActivity.show()
            return@postDelayed
        }
        viewState.showAuth()

    }, 2000)
}
}
package com.example.snakess.registration

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.snakess.domain.models.User
import java.util.*


interface IRegistrationView: MvpView {
    fun showError(text:String)
    fun validation(login:String,pass:String)
    fun fetchUser(data: List<User>)
    fun loading()

}
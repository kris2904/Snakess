package com.example.snakess.authorization

import com.arellomobile.mvp.MvpView
import com.example.snakess.registration.IRegistrationView

interface IAurhView:MvpView {
    fun showError(text:String)
    fun validation(login:String,pass:String)
    fun loading()
}
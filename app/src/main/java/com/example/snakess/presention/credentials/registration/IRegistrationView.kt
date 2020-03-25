package com.example.snakess.presention.credentials.registration

import com.arellomobile.mvp.MvpView
import com.example.snakess.base.IBaseView
import com.example.snakess.domain.di.models.User


interface IRegistrationView: IBaseView {
    fun showError(text:String)
 /*   fun validation(login:String,pass:String)
    fun fetchUser(data: List<User>)
    fun loading()*/

}
package com.example.snakess.presention.credentials.authorization

import com.arellomobile.mvp.MvpView
import com.example.snakess.base.IBaseView

interface IAurhView: IBaseView {
    fun onSuccess()
    fun showError(text:String)
    /*fun validation(login:String,pass:String)
    fun loading()*/

}
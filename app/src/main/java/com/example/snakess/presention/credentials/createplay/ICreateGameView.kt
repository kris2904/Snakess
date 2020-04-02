package com.example.snakess.presention.credentials.createplay

import com.arellomobile.mvp.MvpView
import com.example.snakess.base.IBaseView

interface ICreateGameView:IBaseView {
    fun showError(text:String)
    fun showLobby()
}
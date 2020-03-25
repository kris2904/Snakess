package com.example.snakess.presention.credentials.loading

import com.arellomobile.mvp.MvpView

interface ILoaderView: MvpView {
    fun onLoadingComplete()
    //fun chackAuth():Boolean
/*    fun showLoading()
    fun hideLoading()*/
    fun showMenuFragment()
    fun showAuthActivity()
}
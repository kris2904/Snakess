package com.example.snakess.main.loading

import com.arellomobile.mvp.MvpView

interface ILoaderView: MvpView {
    fun showLoading()
    fun hideLoading()
    fun showMenuFragment()
    fun showAuthActivity()
}
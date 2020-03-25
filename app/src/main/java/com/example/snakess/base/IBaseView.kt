package com.example.snakess.base

import com.arellomobile.mvp.MvpView

interface IBaseView:MvpView {
    fun lock()//заблокировать
    fun unlock()//разблокировать
    fun onSuccess(message: String)//успешно
    fun onError(message: String)//ошибка
}
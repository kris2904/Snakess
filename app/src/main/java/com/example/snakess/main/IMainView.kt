package com.example.snakess.main

import com.arellomobile.mvp.MvpView
import com.example.snakess.domain.di.models.User


interface IMainView:MvpView {
    fun checkAuth(login: User, pass:User)//Проверяем авторизирован ли пользователь,если нет то преребрасываем его в LoginActivity
    fun loding()

}
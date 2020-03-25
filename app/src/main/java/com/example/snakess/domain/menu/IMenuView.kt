package com.example.snakess.domain.menu

import com.arellomobile.mvp.MvpView
import com.example.snakess.domain.di.models.User

interface IMenuView : MvpView {
    fun checkAuth(login: User, pass: User)//Проверяем авторизирован ли пользователь,если нет то преребрасываем его в LoginActivity
    fun loding()

}
package com.example.snakess.activitys

import android.content.Intent
import android.os.Bundle
import com.example.snakess.App
import com.example.snakess.domain.menu.MenuFragment
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.presention.credentials.loading.LoadingFragment
import com.example.snakess.presention.credentials.menu.IMenuRouter


class MenuActivity: ABaseActivity(),IMenuRouter {
    companion object {
        private const val ARG_DROP_MENU = "ARG_DROP_MENU"
        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, MenuActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_MENU, true)
                })
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека
        if (intent.getBooleanExtra(ARG_DROP_MENU, false)) {
            showMenu()
            return
        }
        showLoading()
    }

    override fun showLoading() {
        replace(LoadingFragment())
    }
    override fun showMenu() {
        replace(MenuFragment())

    }
}
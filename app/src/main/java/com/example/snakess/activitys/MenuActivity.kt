package com.example.snakess.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.snakess.App
import com.example.snakess.domain.menu.MenuFragment
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.domain.di.models.User
import com.example.snakess.domain.menu.IMenuView
import com.example.snakess.domain.menu.MenuPresenter
import com.example.snakess.presention.credentials.loading.LoadingFragment
import com.example.snakess.presention.credentials.menu.IMenuRouter


class MenuActivity:ABaseActivity(), IMenuRouter {

    var manuFragment:MenuFragment= MenuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //MenuActivity.show()
        if(true)//(!presenter.checkAuth())
        {
           startActivity(Intent(this, LoginActivity::class.java))
        }
        else{
          //  showMenu()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, manuFragment)
                .commit()
        }
    }



    override fun showLoading() {
        replace(LoadingFragment())
    }
    override fun showMenu() {
        replace(MenuFragment())

    }
}
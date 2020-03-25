package com.example.snakess.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.snakess.domain.menu.MenuFragment
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.domain.di.models.User
import com.example.snakess.domain.menu.IMenuView
import com.example.snakess.domain.menu.MenuPresenter
import com.example.snakess.presention.credentials.loading.LoadingFragment
import com.example.snakess.presention.menu.IMenuRouter


class MenuActivity:ABaseActivity(), IMenuRouter {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        if(savedInstanceState!=null)
            return
        showLoading()
      /*  if(true)//(!presenter.checkAuth())
        {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, manuFragment)
                .commit()
        }*/
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,MenuActivity::class.java)
        startActivity(intent)
    }


    override fun showLoading() {
        replace(LoadingFragment())
    }
    override fun showMenu() {
        if(true)//(!presenter.checkAuth())
        {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        else{
            replace(MenuFragment())
        }
    }
}
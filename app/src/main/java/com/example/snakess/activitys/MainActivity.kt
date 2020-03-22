package com.example.snakess.activitys

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.snakess.MenuFragment
import com.example.snakess.R
import com.example.snakess.domain.di.models.User
import com.example.snakess.main.IMainView
import com.example.snakess.main.MainPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {
    var manuFragment:MenuFragment= MenuFragment()
    @InjectPresenter
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(!presenter.checkAuth())
         {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        else{
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_menu, manuFragment)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    override fun checkAuth(login: User, pass: User) {
        TODO("Not yet implemented")
    }

    override fun loding() {
        TODO("Not yet implemented")
    }
    //View implementation
}

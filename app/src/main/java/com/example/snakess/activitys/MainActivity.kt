package com.example.snakess.activitys

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.snakess.R
import com.example.snakess.domain.models.User
import com.example.snakess.main.IMainView
import com.example.snakess.main.MainPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(presenter.checkAuth())
         {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        else{
            this.findNavController(R.id.menuFragment).navigate(R.id.navHostMain1)
           //findNavController(R.id.navHostMain1).navigateUp()

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

/*
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostMain1).navigateUp()
    }
*/

    override fun checkAuth(login: User, pass: User) {

    }

    override fun loding() {
        TODO("Not yet implemented")
    }
    //View implementation
}

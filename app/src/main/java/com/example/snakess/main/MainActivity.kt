package com.example.snakess.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.snakess.R
import com.example.snakess.activitys.LoginActivity
import com.example.snakess.domain.models.User

class MainActivity : MvpAppCompatActivity(),IMainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(true)//(!presenter.checkAuth())
         {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        else{
            onSupportNavigateUp()
        }
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)
    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostMain1).navigateUp()
    }

    override fun checkAuth(login: User, pass: User) {

    }

    override fun loding() {
        TODO("Not yet implemented")
    }
    //View implementation
}

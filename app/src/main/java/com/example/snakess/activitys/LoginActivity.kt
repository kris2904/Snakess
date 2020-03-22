package com.example.snakess.activitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.snakess.R
import com.example.snakess.authorization.AuthorizationFragment
import com.example.snakess.registration.RegistrationFragment

class LoginActivity : AppCompatActivity() {

     var authFragment: AuthorizationFragment = AuthorizationFragment() //фрагмент с формой авторизации
     var regFragment:RegistrationFragment= RegistrationFragment()    //фрагмент с формой регистрации


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_auth_reg,authFragment)
            .commit()
    }



    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun onClicFragment(){


    }
}

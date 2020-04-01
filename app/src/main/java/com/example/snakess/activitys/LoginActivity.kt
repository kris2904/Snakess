package com.example.snakess.activitys

import android.content.Intent
import android.os.Bundle
import com.example.snakess.App
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.domain.repositories.local.UserStorage
import com.example.snakess.presention.ILoginRouter
import com.example.snakess.presention.credentials.authorization.AuthorizationFragment
import com.example.snakess.presention.credentials.loading.LoadingFragment
import com.example.snakess.presention.credentials.registration.RegistrationFragment

class LoginActivity : ABaseActivity(),ILoginRouter {
    companion object {

        private const val ARG_DROP_CREDENTIALS = "ARG_DROP_CREDENTIALS"

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_CREDENTIALS, true)
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (savedInstanceState != null)
            return
        if(intent.getBooleanExtra(ARG_DROP_CREDENTIALS,false)) {
            UserStorage().dropCredentials()
            showAuth()
            return
        }
        showLoading()
    }


    override fun showLoading(){
        replace(LoadingFragment())
    }

    override fun showRegistration() {
       replace(RegistrationFragment(),"Registration")
    }

    override fun showAuth() {
       replace(AuthorizationFragment())
    }




}

package com.example.snakess.activitys

import android.content.Intent
import android.os.Bundle
import com.example.snakess.App
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.presention.routers.ICreategameRouter
import com.example.snakess.presention.credentials.createplay.CreateGameFragment
import com.example.snakess.presention.credentials.lobby.LobbyFragment

class CreategameActivity : ABaseActivity(),
    ICreategameRouter {
    companion object {
        private const val ARG_DROP_CREATE_GAME = "ARG_DROP_CREATE_GAME"

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, CreategameActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_CREATE_GAME, true)
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creategame)
        if (savedInstanceState != null)
            return
        if (intent.getBooleanExtra(ARG_DROP_CREATE_GAME, false)) {
            showCreategame()
            return
        }
    }

    override fun showCreategame() {
        replace(CreateGameFragment())
    }

    override fun showLoabby() {
        replace(LobbyFragment(), "Lobby")
    }


}

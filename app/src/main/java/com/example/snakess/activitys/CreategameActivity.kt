package com.example.snakess.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.snakess.App
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.domain.repositories.local.UserStorage
import com.example.snakess.presention.ICreategameRouter
import com.example.snakess.presention.ILoginRouter
import com.example.snakess.presention.credentials.createplay.CreateGameFragment
import com.example.snakess.presention.credentials.loading.LoadingFragment
import com.example.snakess.presention.credentials.lobby.LobbyFragment
import com.example.snakess.presention.credentials.menu.MenuFragment
import kotlinx.android.synthetic.main.fragment_menu.*

class CreategameActivity : ABaseActivity(), ICreategameRouter {
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

   /* override fun onBackPressed() {
        super.onBackPressed()
    }*/


    override fun showCreategame() {
        replace(CreateGameFragment())

    }

    override fun showLoabby() {
        replace(LobbyFragment(), "Lobby")
    }


}

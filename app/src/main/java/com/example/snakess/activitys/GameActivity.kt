package com.example.snakess.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.App
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.game.GameFragment
import com.example.snakess.presention.game.GamePresenter
import com.example.snakess.presention.game.GameView
import com.example.snakess.presention.game.IGameView
import com.example.snakess.presention.routers.IGameRouter
import kotlinx.android.synthetic.main.activity_game.*
import javax.inject.Inject

class GameActivity : ABaseActivity(),IGameRouter {
    val TAG = "GameActivity"
    companion object {
        private const val ARG_DROP_GAME = "ARG_DROP_GAME"

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, GameActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_GAME, true)
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        if (savedInstanceState != null)
            return
        if (intent.getBooleanExtra(ARG_DROP_GAME, false)) {
           showGame()
            return
        }

    }

    override fun showGame() {
        replace(GameFragment())
    }
}

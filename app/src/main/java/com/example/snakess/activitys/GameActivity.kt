package com.example.snakess.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.App
import com.example.snakess.R
import com.example.snakess.base.ABaseActivity
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.game.GamePresenter
import com.example.snakess.presention.game.IGameView
import com.example.snakess.presention.routers.IGameRouter
import javax.inject.Inject

class GameActivity : ABaseActivity(),IGameView,IGameRouter {
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
    @Inject
    @InjectPresenter
    lateinit var presenterGame:GamePresenter
    @ProvidePresenter
    fun providePresenter()=presenterGame

     fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null)
            return
        if (intent.getBooleanExtra(ARG_DROP_GAME, false)) {
            setContentView(R.layout.activity_game)
        }
    }

}

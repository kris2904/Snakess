package com.example.snakess.presention.game


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Constraints.TAG
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakess.R
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import kotlinx.android.synthetic.main.fragment_game.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : ABaseFragment(),IGameView {
    val TAG = "GameFragment"
    @Inject
    @InjectPresenter
    lateinit var presenterGame:GamePresenter
    @ProvidePresenter
    fun providePresenter()=presenterGame

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId()=R.layout.fragment_game

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека
        presenterGame.showScore()
        snake_right.setOnClickListener(){
            presenterGame.right()
        }
        snake_left.setOnClickListener(){
            presenterGame.left()
        }
        snake_up.setOnClickListener(){
            presenterGame.top()
        }
        snake_bottom.setOnClickListener(){
            Log.d(TAG, "CLIC_bottom")
            presenterGame.bottom()
        }
    }

    override fun goRight() {
        playing_field.setDirection(GameView.RIGHT_DIRECTION)
    }

    override fun goLeft() {
        playing_field.setDirection(GameView.LEFT_DIRECTION)
    }

    override fun goTop() {
        playing_field.setDirection(GameView.TOP_DIRECTION)
    }

    override fun goBottom() {
        playing_field.setDirection(GameView.BOTTOM_DIRECTION)
    }

    override fun showScore(scor: Int) {
        game_result.text="$scor"
    }


}

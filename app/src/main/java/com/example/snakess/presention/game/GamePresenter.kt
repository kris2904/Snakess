package com.example.snakess.presention.game

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class GamePresenter: MvpPresenter<IGameView> {


    @Inject
    constructor( ){

    }

    fun right() {
        viewState.goRight()
    }

    fun left() {
        viewState.goLeft()
    }

    fun top() {
      viewState.goTop()
    }

   fun bottom() {
       viewState.goBottom()
    }
    fun showScore(){
        viewState.showScore(0)
    }

}
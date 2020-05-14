package com.example.snakess.presention.game

import com.arellomobile.mvp.MvpView

interface IGameView: MvpView {
    fun goRight()
    fun goLeft()
    fun goTop()
    fun goBottom()
    fun showScore(scor:Int)
}
package com.example.snakess.presention.game.ui.snakeGameObject

import com.example.snakess.presention.game.GameView

abstract class ABaseGame {
     open var width: Int=0
     open var height:Int=0

    fun getStartX():Int{
        return (width - getCountByWidth() * getSize()) / 2
    }
    fun getStartY():Int{
        return (height -getCountByHeight() * getSize()) / 2
    }
    fun getSize()=40

    fun getCountByWidth(): Int {
        return width / getSize()
    }
     fun getCountByHeight(): Int {
        return height / getSize()
    }
}
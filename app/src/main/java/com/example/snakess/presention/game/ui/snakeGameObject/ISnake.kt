package com.example.snakess.presention.game.ui.snakeGameObject

import android.graphics.Canvas

interface ISnake {

    fun move()
    fun drawSnake(canvas: Canvas)
    fun addElementList()
}
package com.example.snakess.presention.game.ui.snakeGameObject

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.snakess.presention.game.GameView

class SnakePieces(var x: Int, var y: Int):ABaseGame() {
    private var snake:SnakeObject

    private val paintHaid = Paint().apply {
        color = Color.WHITE
    }
    var Direction:Int?=GameView.RIGHT_DIRECTION
    var isStart:Boolean?=false

    init {
        this.snake=SnakeObject(x,y,Direction,isStart)
    }
    /* fun drawSnake(canvas: Canvas){
        // if(mSnakePaths[i].isStart)
        canvas.drawCircle(
            (x.toFloat()+(getCountByWidth().toFloat()*0.5f)),
            (y.toFloat())+(getCountByHeight().toFloat()*0.5f),
            getCountByWidth().toFloat()*0.5f,
            paintHaid)
    }*/

    }
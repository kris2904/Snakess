package com.example.snakess.presention.game.ui.snakeGameObject

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.snakess.presention.game.ui.PlayingFeldUI

class Snake:ISnake {
    private val paintHaid = Paint().apply {
        color = Color.WHITE
    }
    //private var mP=PlayingFeldUI()
   // private var mSnakePaths=ArrayList<SnakePieces>()
    private var countPaths=3
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun drawSnake(canvas: Canvas) {
         /*       for(i in 0 until  mP.mSnakePaths.size){
                    mP.mSnakePaths[i].drawSnake(canvas)
            }*/
    }

    override fun addElementList() {
        TODO("Not yet implemented")
    }
}
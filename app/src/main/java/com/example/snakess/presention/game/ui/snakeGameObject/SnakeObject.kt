package com.example.snakess.presention.game.ui.snakeGameObject

import android.content.Context
import com.example.snakess.presention.game.GameView

data class SnakeObject(var x: Int, var y: Int, var Direction:Int?, var isStart: Boolean?) {
    //constructor(x:Int,y:Int):this(x,y, GameView.RIGHT_DIRECTION,false)
}

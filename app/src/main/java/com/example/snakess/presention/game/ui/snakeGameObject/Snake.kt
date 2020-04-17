package com.example.snakess.presention.game.ui.snakeGameObject

import com.example.snakess.presention.game.GameView

class Snake(var x: Int, var y: Int) {
    private var snake:SnakeObject
    var Direction:Int?=GameView.RIGHT_DIRECTION
    var isStart:Boolean?=false

    init {
        this.snake=SnakeObject(x,y,Direction,isStart)
    }

}
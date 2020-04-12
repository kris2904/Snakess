package com.example.snakess.presention.game.ui.snakeGameObject

import android.content.Context

class Game(context:Context,width:Int,haight:Int) {
    private var raning:Boolean = false
    private var sleepTime:Long = 0

    companion object{
        public var haight:Int = 0
        public var width:Int = 0
        public var cellHeight:Int=0
        public var cellWidth=0
    }
    private lateinit var snake:Snake
    private lateinit var apple:Apple




}
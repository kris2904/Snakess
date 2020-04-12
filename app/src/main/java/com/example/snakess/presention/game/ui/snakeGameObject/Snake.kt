package com.example.snakess.presention.game.ui.snakeGameObject

import android.graphics.Canvas

class Snake{
    private lateinit var snakeParts:ArrayList<GameObject>
    var x:Int=0
    var y:Int=0
    companion object{
        const val HEAD_SIGN="\uD83D\uDC7E"
        const val BODY_SIGN="\u26AB"
    }
       constructor(x:Int,y:Int){
        this.x=x
        this.y=y
        var s1=GameObject(x,y)
        var s2=GameObject(x+1,y)
        var s3=GameObject(x+2,y)
        snakeParts.add(0,s1)
        snakeParts.add(2,s2)
        snakeParts.add(3,s3)
    }
    fun drow(canvas:Canvas){

    }
}
package com.example.snakess.presention.game.ui.snakeGameObject

import android.graphics.Canvas
import com.example.snakess.presention.game.ui.ElementUI

open class GameObject internal constructor(var x:Int,var y:Int){

    var width: Int = 0
    var height: Int = 0

        fun renderHaid(E:ElementUI,canvas: Canvas){
              E.render(canvas)
    }

}
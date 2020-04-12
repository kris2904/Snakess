package com.example.snakess.presention.game.ui.snakeGameObject

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.snakess.presention.game.ui.ElementUI

class  Apple(x: Int, y: Int):GameObject(x,y) {

    companion object {
        const val APPLE_SIGN = "\uD83C\uDF4E"
    }
    fun drow(element:ElementUI,canvas: Canvas){
        element.render(canvas)
}

}
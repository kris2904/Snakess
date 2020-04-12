package com.example.snakess.presention.game.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.snakess.presention.game.ui.snakeGameObject.Apple
import com.example.snakess.presention.game.ui.snakeGameObject.GameObject

open class ElementUI: IElementUI {


    companion object {
        const val STATE_UNDEFINED = 0
        const val STATE_APPLE = 1
        const val STATE_HAID = 2

        val paintHaid = Paint().apply {
            color = Color.WHITE
        }
            val paintBlack = Paint().apply { color = Color.BLACK }//

    }
    var x: Int = 0
    var y: Int = 0

    var width: Int = 0
    var height: Int = 0

    var state: Int = STATE_UNDEFINED


    override fun render(canvas: Canvas) {
        when (state) {
            STATE_APPLE -> renderApple(canvas)
            STATE_HAID -> renderHaid(canvas)
        }
    }

    override fun render_snake(canvas: Canvas) {
        TODO("Not yet implemented")
    }

    private fun renderApple(canvas: Canvas){
    }
    private fun renderHaid(canvas: Canvas){
        val x = x.toFloat()
        val y = y.toFloat()
        val w = width.toFloat()
        val h = height.toFloat()
        val hw=w*0.5f
        val cx=x+hw
        val cy=y+h*0.5f
        canvas.drawCircle(cx, cy, hw,paintHaid)
    }

}
package com.example.snakess.presention.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.example.snakess.presention.game.ui.snakeGameObject.GameObject
import kotlin.random.Random

//
class PlayingFeldUI:IElementUI {
    private val takes= mutableListOf<ElementUI>()
    private val bgPaint= Paint().apply { color=Color.GREEN }

    var width: Int = 0
    var height: Int = 0
    init {

        val random = Random(System.currentTimeMillis())
        for (i in 0..2){
            takes.add(ElementUI().apply {
                state = 2
            })}
    }

    override fun render(canvas: Canvas) {
        canvas.drawRect(Rect(0,0,width,height),bgPaint)

        val itemWidth = width / 10
        val itemHeight = height / 10

        var row = 2
        var col = 5
      //  for (x in 0 until 15)
        for (take in takes) {

            take.x = col * itemWidth
            take.y = row * itemHeight

            take.width = itemWidth
            take.height = itemHeight

            take.render(canvas)

            if(++col==10){
                col=0
                if(++row==10)
                    return
            }

        }
        ++row
    }

    override fun render_snake(canvas: Canvas) {

    }


}
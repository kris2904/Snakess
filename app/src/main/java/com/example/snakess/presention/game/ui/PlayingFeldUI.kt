package com.example.snakess.presention.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

//
class PlayingFeldUI:IElementUI {
    private val takes= mutableListOf<TakeUI>()
    private val bgPaint= Paint().apply { color=Color.GREEN }

    var width: Int = 0
    var height: Int = 0

    override fun render(canvas: Canvas) {
        canvas.drawRect(Rect(0,0,width,height),bgPaint)
   /*     val itemWidth = width / 3
        val itemHeight = height / 3

        var row = 0
        var col = 0

      //  for (x in 0 until 15)
        for (take in takes) {

            take.x = col * itemWidth
            take.y = row * itemHeight

            take.width = itemWidth
            take.height = itemHeight

            take.render(canvas)

            if(++col==3){
                col=0
                if(++row==3)
                    return
            }
            row++
        }*/
    }
}
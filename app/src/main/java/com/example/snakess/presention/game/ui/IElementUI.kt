package com.example.snakess.presention.game.ui

import android.graphics.Canvas

interface IElementUI {
    fun render(canvas:Canvas)
    fun render_snake(canvas: Canvas)
}
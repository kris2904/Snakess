package com.example.snakess.presention.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Handler
import android.util.Log
import com.example.snakess.presention.game.GameView
import com.example.snakess.presention.game.ui.snakeGameObject.ABaseGame
import com.example.snakess.presention.game.ui.snakeGameObject.Snake
import com.example.snakess.presention.game.ui.snakeGameObject.SnakePieces
import kotlin.random.Random

//
class PlayingFeldUI : IElementUI, ABaseGame() {
    val TAG = "PlayingFeldUI"
    private val paintBody = Paint().apply {
        color = Color.WHITE
    }
    private val paintHaid = Paint().apply {
        color = Color.GREEN
    }
    var mSnakePaths=ArrayList<SnakePieces>()
    private var countPaths=3
    private val bgPaint = Paint().apply { color = Color.GRAY }

    override var width: Int = 0
    override var height: Int = 0

    init {
        var random = Random(System.currentTimeMillis())
        addElementList()
    }

    override fun render(canvas: Canvas) {
        canvas.drawRect(Rect(0, 0, width, height), bgPaint)
        drawSnake(canvas)
    }

    override fun render_snake(canvas: Canvas) {
    }

    fun move() {
        Log.d(TAG, "move")
        var previousDirection = mSnakePaths[0].Direction
        for (i in 0 until mSnakePaths.size) {
            when (mSnakePaths[i].Direction) {

                GameView.RIGHT_DIRECTION -> {
                    mSnakePaths[i].x += getSize()
                    if (mSnakePaths[i].x + getSize() > width) {
                        mSnakePaths[i].x = getStartX()
                    }
                }
                GameView.LEFT_DIRECTION -> {
                    mSnakePaths[i].x -= getSize()
                    if (mSnakePaths[i].x < 0) {
                        mSnakePaths[i].x = width - getStartX() - getSize()
                    }
                }
                GameView.TOP_DIRECTION -> {
                    mSnakePaths[i].y -= getSize()
                    if (mSnakePaths[i].y < 0) {
                        mSnakePaths[i].y = height - getStartY() - getSize()
                    }

                }
                GameView.BOTTOM_DIRECTION -> {
                    mSnakePaths[i].y += getSize()
                    if (mSnakePaths[i].y + getSize() > height) {
                        mSnakePaths[i].y = getStartX()
                    }

                }
            }
                    if (i > 0 && mSnakePaths[i].Direction != previousDirection) {
                        val directionSwap = previousDirection
                        previousDirection = mSnakePaths[i].Direction
                        mSnakePaths[i].Direction = directionSwap
                    }
                }
                /*for (take in takes) {
            take.x += 158
            take.y += 0
        }*/
            }

        fun addElementList() {
            if (mSnakePaths.isEmpty()) {
                for (i in 0 until countPaths) {
                    mSnakePaths.add(
                        SnakePieces(
                            getStartX() + (countPaths - 1 - i) * getSize(),
                            getStartY()
                        )
                    )
                    if (i == 0) {
                        mSnakePaths.last().isStart = true
                    }
                }
            }
        }

        fun drawSnake(canvas: Canvas) {

            for (i in 0 until mSnakePaths.size) {
                if (mSnakePaths[i].isStart == true)
                    canvas.drawCircle(
                        (mSnakePaths[i].x.toFloat()) + (getCountByWidth().toFloat() * 0.5f),
                        (mSnakePaths[i].y.toFloat()) + (getCountByHeight().toFloat() * 0.5f),
                        getCountByWidth().toFloat() * 0.5f,
                        paintHaid
                    )
                else
                    canvas.drawCircle(
                        (mSnakePaths[i].x.toFloat()) + (getCountByWidth().toFloat() * 0.5f),
                        (mSnakePaths[i].y.toFloat()) + (getCountByHeight().toFloat() * 0.5f),
                        getCountByWidth().toFloat() * 0.5f,
                        paintBody
                    )
            }
            //snake.drawSnake(canvas)

        }
    fun setDirection(direction: Int) {
        Log.d(TAG,"PLAY_setDirection")
        when (direction) {
            GameView.RIGHT_DIRECTION -> {
                if (mSnakePaths[0].Direction != GameView.LEFT_DIRECTION)
                    mSnakePaths[0].Direction = direction
            }
            GameView.LEFT_DIRECTION -> {
                if (mSnakePaths[0].Direction != GameView.RIGHT_DIRECTION)
                    mSnakePaths[0].Direction = direction

            }
            GameView.BOTTOM_DIRECTION -> {
                Log.d(TAG,"PLAY_setDirection_BOTTOM_DIRECTION")
                if (mSnakePaths[0].Direction != GameView.TOP_DIRECTION)
                    mSnakePaths[0].Direction = direction
            }
            GameView.TOP_DIRECTION -> {
                if (mSnakePaths[0].Direction != GameView.BOTTOM_DIRECTION)
                    mSnakePaths[0].Direction = direction
            }
        }
    }

    }


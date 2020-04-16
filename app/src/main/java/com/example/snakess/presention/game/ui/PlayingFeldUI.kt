package com.example.snakess.presention.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Handler
import android.util.Log
import com.example.snakess.presention.game.GameView
import com.example.snakess.presention.game.ui.snakeGameObject.Snake
import kotlin.random.Random

//
class PlayingFeldUI : IElementUI {
    val TAG = "PlayingFeldUI"
    private val paintHaid = Paint().apply {
        color = Color.WHITE
    }
    private var mSnakePaths=ArrayList<Snake>()
    private var countPaths=3
   // private var apple= Apple()
    private val mHandler = Handler()
   // private var scores = 0
   // private val mSnakeRunnable=SnakeRunnable()
    //private lateinit var gameView:IElementUI


    private val takes = mutableListOf<ElementUI>()
    //private val runSnake = SnakeRun()
    private val bgPaint = Paint().apply { color = Color.GREEN }

    var width: Int = 0
    var height: Int = 0


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
        Log.d(TAG,"move")
        var previousDirection=mSnakePaths[0].Direction
        for(i in 0 until mSnakePaths.size){
            when(mSnakePaths[i].Direction){
                GameView.RIGHT_DIRECTION -> {
                    mSnakePaths[i].x += getSize()
                    if(mSnakePaths[i].x+getSize()>width){
                        mSnakePaths[i].x=getStartX()
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
    fun addElementList(){
        if(mSnakePaths.isEmpty()) {
            for (i in 0 until countPaths) {
                mSnakePaths.add(Snake(getStartX() + (countPaths - 1 - i) * getSize(), getStartY()))
             if (i == 0) {
                    mSnakePaths.last().isStart = true
                }
            }
        }
    }
    fun drawSnake(canvas: Canvas){
        for(i in 0 until  mSnakePaths.size){
            // if(mSnakePaths[i].isStart)
            canvas.drawCircle(
                (mSnakePaths[i].x.toFloat())+(getCountByWidth().toFloat()*0.5f),
                (mSnakePaths[i].y.toFloat())+(getCountByHeight().toFloat()*0.5f),
                getCountByWidth().toFloat()*0.5f,
                paintHaid)
        }
    }
    fun getStartX():Int{
        return (width - getCountByWidth() * getSize()) / 2
    }
    fun getStartY():Int{
        return (height -getCountByHeight() * getSize()) / 2
    }
    fun getSize()=40

    private fun getCountByWidth(): Int {
        return width / getSize()
    }
    private fun getCountByHeight(): Int {
        return height / getSize()
    }

    }

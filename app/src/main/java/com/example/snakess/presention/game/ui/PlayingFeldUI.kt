package com.example.snakess.presention.game.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Handler
import android.util.Log
import com.example.snakess.presention.game.GameView
import com.example.snakess.presention.game.ui.snakeGameObject.*
import kotlin.random.Random
import kotlin.collections.last as last

//
class PlayingFeldUI : IElementUI, ABaseGame() {
    val TAG = "PlayingFeldUI"
    private val paintBody = Paint().apply { color = Color.WHITE }
    private val paintHaid = Paint().apply { color = Color.GREEN }
    private val bgPaint = Paint().apply { color = Color.GRAY }

    var mSnakePaths=ArrayList<SnakeObject>()
    private var countPaths=3
    private var mApple = Apple(getStartX() + (Math.random() * getCountByWidth()).toInt() * getSize(),
        getStartY() + (Math.random() * getCountByHeight()).toInt() * getSize())

    override var width: Int = 0
    override var height: Int = 0

    init {
        var random = Random(System.currentTimeMillis())
    /*   if(mApple.x==getStartX() + (Math.random() * getCountByWidth()).toInt() * getSize()){
           mApple=generateApple()
       }*/
       /*if(mApple.x==-1){
            generateApple()
        }*/
        addElementList()
    }

    override fun render(canvas: Canvas) {
        canvas.drawRect(Rect(0, 0, width, height), bgPaint)
        drawSnake(canvas)
       // render_snake(canvas)

    }

    override fun render_snake(canvas: Canvas) {
        canvas.drawCircle(
            (mApple.x.toFloat()) + (getCountByWidth().toFloat() * 0.5f),
            (mApple.y.toFloat()) + (getCountByHeight().toFloat() * 0.5f),
            getCountByWidth().toFloat() * 0.5f,
            paintBody
        )
    }

    fun move() {

        if (mSnakePaths[0].x == mApple.x && mSnakePaths[0].y == mApple.y) {
            addPathSnake()
            mApple=Apple(generateApple().x, generateApple().y)
        }
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
                        SnakeObject(
                            getStartX() + (countPaths - 1 - i) * getSize(),
                            getStartY(),GameView.RIGHT_DIRECTION,false
                        )
                    )
                    if (i == 0) {
                        mSnakePaths.last().isStart = true
                    }
                }
            }
        }
    fun generateApple():Apple{
        val resApple=Apple((Math.random() * getCountByWidth()).toInt()*getSize() ,
            (Math.random() * getCountByHeight()).toInt()*getSize()
        )
        for(i in 0 until mSnakePaths.size){
            if(mSnakePaths[i].x==resApple.x && mSnakePaths[i].y==resApple.y)
                return generateApple()
        }
        return resApple
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
            canvas.drawCircle(
                (mApple.x.toFloat()) + (getCountByWidth().toFloat() * 0.5f),
                (mApple.y.toFloat()) + (getCountByHeight().toFloat() * 0.5f),
                getCountByWidth().toFloat() * 0.5f,
                paintBody
            )
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
    //


    fun addPathSnake(){
        val lastPath=mSnakePaths.last()
        when( lastPath.Direction) {
            GameView.RIGHT_DIRECTION -> {
                val mPath = SnakeObject( lastPath.x - getSize(), lastPath.y, lastPath.Direction,false)
                if (mPath.x < getStartX())
                    mPath.x = getStartX() + getCountByWidth() * getSize()
                mSnakePaths.add(mPath)
            }
            GameView.LEFT_DIRECTION -> {
                val mPath = SnakeObject(lastPath.x + getSize(), lastPath.y,lastPath.Direction,false)
                if (mPath.x > width - getStartX())
                    mPath.x = getStartX()
                mSnakePaths.add(mPath)
            }
            GameView.BOTTOM_DIRECTION -> {
                val mPath = SnakeObject(lastPath.x, lastPath.y - getSize(),lastPath.Direction,false)
                if (mPath.y < getStartY())
                    mPath.y = getStartY() + getCountByHeight() * getSize()
                mSnakePaths.add(mPath)
            }
            GameView.TOP_DIRECTION -> {
                val mPath = SnakeObject(lastPath.x, lastPath.y + getSize(),lastPath.Direction,false)
                if (mPath.y > height - getStartY())
                    mPath.y = getStartY()
                mSnakePaths.add(mPath)
            }
        }
    }

    }


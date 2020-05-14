package com.example.snakess.presention.game

import android.content.Context
import android.graphics.Canvas
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.snakess.activitys.GameActivity
import com.example.snakess.presention.game.ui.PlayingFeldUI

class GameView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback{
    val TAG = "GameView"

    private val mHandler = Handler()
    private val mSnakeRunnable = SnakeRunnable()
    lateinit var gameFragment:GameFragment

    companion object {
        const val RIGHT_DIRECTION = -1
        const val BOTTOM_DIRECTION = -2
        const val LEFT_DIRECTION = -3
        const val TOP_DIRECTION = -4

    }

    private var sfHolder: SurfaceHolder? = null
        set(value) {
            field = value
            value?.addCallback(this)
        }

    private val playingFeldUI = PlayingFeldUI()

    init {
        sfHolder = holder
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        sfHolder = null
        mHandler.removeCallbacks(mSnakeRunnable)
    }

    //получаем ссылку на наш холст-canvas
    override fun surfaceCreated(holder: SurfaceHolder?) {
        sfHolder = holder

    }

    fun render() {
        val holder = sfHolder ?: return
        var canvas: Canvas? = null
        try {
            canvas = holder.lockCanvas()
            if (canvas != null)
                render(canvas)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            canvas?.let {

                holder.unlockCanvasAndPost(it)
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        postOnAnimation({ render() })
        // postDelayed({ render() }, 2000)
        //render()

    }

    private fun render(canvas: Canvas) {
        playingFeldUI.width = width
        playingFeldUI.height = height
        playingFeldUI.render(canvas)
        mHandler.postDelayed(mSnakeRunnable, 500L)


    }

   fun moveSnake() {
       playingFeldUI.move()
       invalidate()
    }

    private inner class SnakeRunnable : Runnable {
        override fun run() {
            Log.d(TAG,"run")
            render()
            moveSnake()
        }
    }
    fun setDirection(direction: Int){
        Log.d(TAG,"PLAY_setDirection")
        playingFeldUI.setDirection(direction)
        invalidate()
    }
}
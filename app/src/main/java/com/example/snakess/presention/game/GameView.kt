package com.example.snakess.presention.game

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView @JvmOverloads constructor(
  context:Context,attrs:AttributeSet?=null,defStyleAttr:Int=0
):SurfaceView(context,attrs,defStyleAttr),SurfaceHolder.Callback{

    private var sfHolder:SurfaceHolder?=null
        set(value){
            field=value
            value?.addCallback(this)
        }
    init{
        sfHolder=holder
    }
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        sfHolder=null
    }
//получаем ссылку на наш холст-canvas
    override fun surfaceCreated(holder: SurfaceHolder?) {
    sfHolder=holder
    }
    fun render(){
        val holder=sfHolder?:return
        var canvas: Canvas?=null
        try {
           canvas= holder.lockCanvas()
            if(canvas!=null)
                render(canvas)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
        finally {
            canvas?.let{
                holder.unlockCanvasAndPost(it)}
        }
    }
    private  fun render(canvas:Canvas)
    {
    }
}
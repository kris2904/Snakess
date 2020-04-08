package com.example.snakess.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout

abstract class ABaseView constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context,attrs,defStyleAttr) {
    abstract  fun getViewId(): Int

    init{
        val view= View.inflate(context,getViewId(),this)
    }

}
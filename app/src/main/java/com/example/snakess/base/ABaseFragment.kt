package com.example.snakess.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class ABaseFragment:MvpAppCompatFragment(),IBaseView {
    init {
        inject()
    }
    abstract fun inject()
    abstract fun getViewId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getViewId(), container, false)
    }

    fun toast(@StringRes stringId:Int){
        Toast.makeText(context,stringId,Toast.LENGTH_LONG).show()
    }
    fun toast(massage:String){
        Toast.makeText(context, massage,Toast.LENGTH_LONG).show()
    }
    fun visibility(view:View?,value:Boolean=true){
        view?.visibility =
            if(value)
                View.VISIBLE
            else
                View.GONE
    }

    override fun lock() {
       Log.e(tag(), "fun\"lock\" not yet implemented")
    }

    override fun unlock() {
        Log.e(tag(), "fun\"lock\" not yet implemented")
    }

    override fun onSuccess(message: String) {
        toast(massage = String())
    }

    override fun onError(message: String) {
        toast(massage = String())
    }
    protected  fun  tag() =javaClass.simpleName
}
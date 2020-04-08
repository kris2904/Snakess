package com.example.snakess.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//пересмотреть код
abstract class ABaseAdapter<D,VH:RecyclerView.ViewHolder>:RecyclerView.Adapter<VH>() {
    var data = mutableListOf<D>()
    set(value){
        field=value
        notifyDataSetChanged()
    }

    override fun getItemCount()=data.size

    fun addBeqin(item: D){
        data.add(0,item)
        notifyItemInserted(0)
    }
    fun addFinish(item:D){
        data.add(item)
        notifyItemInserted(data.size-1)
    }

}
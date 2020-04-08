package com.example.snakess.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.snakess.base.ABaseAdapter
import com.example.snakess.domain.repositories.models.rest.GameResult
import com.example.snakess.adapters.PlayerView.ITypeLobbyView
import com.example.snakess.adapters.PlayerView.TypeLobbyView


class PlayersAdapter: ABaseAdapter<GameResult, RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_LOBBY = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View =
            TypeLobbyView(parent.context)
        return object : RecyclerView.ViewHolder(view) {}
    }

   /* override fun getItemViewType(position: Int): Int {
        return TYPE_LOBBY
    }*/

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder.itemView
        if (view is ITypeLobbyView)
            view.bind(data[position])
    }
}
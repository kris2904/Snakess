package com.example.snakess.adapters.PlayerView

import android.content.Context
import android.util.AttributeSet
import com.example.snakess.R
import com.example.snakess.adapters.PlayersAdapter
import com.example.snakess.base.ABaseView
import com.example.snakess.domain.repositories.models.rest.GameResult
import kotlinx.android.synthetic.main.cell_player.view.*

class TypeLobbyView constructor(
    context: Context,attrs:AttributeSet?=null,defStyleAttr:Int=0
):ABaseView(context,attrs,defStyleAttr),
    ITypeLobbyView {

    override fun getViewId()= R.layout.cell_player
    override fun getLobby()=
        PlayersAdapter.TYPE_LOBBY

    override fun bind(gameResult: GameResult){
        txt_loginn_player.text=gameResult.login
    }



}
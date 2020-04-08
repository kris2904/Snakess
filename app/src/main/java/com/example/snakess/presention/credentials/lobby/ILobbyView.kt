package com.example.snakess.presention.credentials.lobby

import com.arellomobile.mvp.MvpView
import com.example.snakess.domain.repositories.models.rest.GameResult


interface ILobbyView:MvpView {
    //fun setupPlayersList(playersList:ArrayList<User>)
    fun setupAdapter()
    fun bindPlayers(date:List<GameResult>)
}
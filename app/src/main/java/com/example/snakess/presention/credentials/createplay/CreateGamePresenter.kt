package com.example.snakess.presention.credentials.createplay

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.repositories.GameRepository
import javax.inject.Inject

@InjectViewState
class CreateGamePresenter: MvpPresenter<ICreateGameView> {
    @Inject
    lateinit var gameRepository :GameRepository
    @Inject
    constructor()
    fun creategame(nameGame:String,kol_players:Int){
        gameRepository.creategamr({
            viewState.showLobby()
        },nameGame,kol_players)
    }
}
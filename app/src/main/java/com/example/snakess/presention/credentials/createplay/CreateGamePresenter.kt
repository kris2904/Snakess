package com.example.snakess.presention.credentials.createplay

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.activitys.GameActivity
import com.example.snakess.domain.repositories.GameRepository
import com.example.snakess.presention.game.GameFragment
import java.util.*
import javax.inject.Inject

@InjectViewState
class CreateGamePresenter: MvpPresenter<ICreateGameView> {
    //@Inject
    private var gameRepository :GameRepository
    @Inject
    constructor(gameRepository :GameRepository){
        this.gameRepository=gameRepository
    }
    fun creategame(nameGame:String,kol_players:Int){
        gameRepository.creategamr({
            if(kol_players>1)
            viewState.showLobby()
            else
                viewState.showGameActivity()
        },nameGame,kol_players)
    }
}
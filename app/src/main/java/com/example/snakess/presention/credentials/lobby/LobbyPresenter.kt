package com.example.snakess.presention.credentials.lobby

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.repositories.GameRepository
import com.example.snakess.domain.repositories.models.rest.GameResult
import javax.inject.Inject

@InjectViewState
class LobbyPresenter:MvpPresenter<ILobbyView> {

    private val repositoryGame:GameRepository
    @Inject
    constructor(repositoryGame:GameRepository){
        this.repositoryGame=repositoryGame
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repositoryGame.fetchPlayers({
            viewState.bindPlayers(it)
        })
    }
}
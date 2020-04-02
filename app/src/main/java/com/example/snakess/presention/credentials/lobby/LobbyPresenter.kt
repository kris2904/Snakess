package com.example.snakess.presention.credentials.lobby

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.snakess.domain.repositories.models.rest.GameResult
import javax.inject.Inject

@InjectViewState
class LobbyPresenter:MvpPresenter<ILobbyView> {
    @Inject
    constructor()

    fun fetchPlayers(){
        val mockDate= ArrayList<GameResult>()
        mockDate.add(GameResult(login = "Кристина",value = 0))
        mockDate.add(GameResult(login = "Молодец",value = 0))
        mockDate.add(GameResult(login = "Немного",value = 0))
        viewState.presentPlayers(date = mockDate)
    }
}
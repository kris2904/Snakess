package com.example.snakess.domain.repositories

import com.example.snakess.domain.repositories.implementation.IGameRepository
import com.example.snakess.domain.repositories.models.rest.GameResult
import io.reactivex.Observable
import javax.inject.Inject

class GameRepository:IGameRepository{
    @Inject
    constructor()
   override fun creategamr(subscriber: (String) -> Unit, nameGame: String, kol_players: Int) {
        subscriber.invoke("$nameGame : $kol_players")
    }
    fun fetchPlayers(observable:(List<GameResult>)->Unit){
            val mockDate= mutableListOf<GameResult>()

            mockDate.add(GameResult(login = "Пользователь1",value = 0))
            mockDate.add(GameResult(login = "Пользователь2",value = 0))
            mockDate.add(GameResult(login = "Пользователь3",value = 0))
            observable(mockDate)

        }

    }
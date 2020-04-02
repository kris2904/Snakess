package com.example.snakess.domain.repositories

import javax.inject.Inject

class GameRepository {
    @Inject
    constructor()
    fun creategamr(subscriber: (String) -> Unit, nameGame: String, kol_players: Int) {
        subscriber.invoke("$nameGame : $kol_players")
    }

}
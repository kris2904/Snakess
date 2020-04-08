package com.example.snakess.domain.repositories.implementation

interface IGameRepository {
    fun creategamr(subscriber: (String) -> Unit, nameGame: String, kol_players: Int)
}
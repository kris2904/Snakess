package com.example.snakess.adapters.PlayerView

import com.example.snakess.domain.repositories.models.rest.GameResult

interface ITypeLobbyView {
    fun getLobby():Int
    fun bind(data:GameResult)
}
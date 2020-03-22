package com.example.snakess.domain.di.models

import java.io.Serializable

data class User( val id: Int? = null,
                 val login: String,
                 val pass: String,
                 val avatar_url: String? = null,
                 val token: Token? = null)
{

}
package com.example.snakess.domain.di.coponents

import com.example.snakess.activitys.GameActivity
import com.example.snakess.domain.di.moduls.NetModuls
import com.example.snakess.presention.credentials.menu.MenuFragment
import com.example.snakess.presention.credentials.authorization.AuthorizationFragment
import com.example.snakess.presention.credentials.createplay.CreateGameFragment
import com.example.snakess.presention.credentials.loading.LoadingFragment
import com.example.snakess.presention.credentials.lobby.LobbyFragment
import com.example.snakess.presention.credentials.registration.RegistrationFragment
import com.example.snakess.presention.game.GameFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetModuls::class))
interface AppComponent {

    //Fragments
    fun inject(target: RegistrationFragment)
    fun inject(target: AuthorizationFragment)
    fun inject(target: LoadingFragment)
    fun inject(target: MenuFragment)
    fun inject(target: CreateGameFragment)
    fun inject(target:LobbyFragment)
    //Activitys
    fun inject(target:GameFragment)
}
package com.example.snakess.presention.credentials.lobby


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakess.R
import com.example.snakess.adapters.PlayersAdapter
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.domain.repositories.models.rest.GameResult
import kotlinx.android.synthetic.main.fragment_lobby.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class LobbyFragment : ABaseFragment(),ILobbyView {
    private var mAdapter=PlayersAdapter()

    @Inject
    @InjectPresenter
    lateinit var presentorLobby:LobbyPresenter
    @ProvidePresenter
    fun providePresenter()=presentorLobby

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId()=R.layout.fragment_lobby

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        presentorLobby.fetchPlayers()

    }


    override fun setupAdapter() {
        val layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recycler_user_lobby.layoutManager=layoutManager
        recycler_user_lobby.adapter=mAdapter
    }

    override fun presentPlayers(date: ArrayList<GameResult>) {
        mAdapter.setupPlayers(gameResulList = date)
    }


}

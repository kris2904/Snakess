package com.example.snakess.presention.credentials.lobby


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import com.example.snakess.activitys.GameActivity
import com.example.snakess.adapters.PlayersAdapter

import com.example.snakess.base.ABaseListFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.domain.repositories.models.rest.GameResult
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class LobbyFragment: ABaseListFragment<GameResult, RecyclerView.ViewHolder>(), ILobbyView {

    private var adapterPlayer=
        PlayersAdapter()
    override fun provideAdapter()=adapterPlayer

    @Inject
    @InjectPresenter
    lateinit var presentorLobby:LobbyPresenter
    @ProvidePresenter
    fun providePresenter()=presentorLobby

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getListId()= R.id.recycler_user_lobby
    override fun getViewId()=R.layout.fragment_lobby

    override fun setupAdapter() {
        TODO("Not yet implemented")
    }

    override fun bindPlayers(data: List<GameResult>) {
       adapterPlayer.data=data.toMutableList()
    }

    override fun showGameActivity() {
       GameActivity.show()
    }
    /*private var mAdapter=PlayersAdapter()

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
     }*/

}

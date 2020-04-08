package com.example.snakess.presention.credentials.lobby


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import com.example.snakess.adapters.PlayersAdapter

import com.example.snakess.base.ABaseListFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.domain.repositories.models.rest.GameResult
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class LobbyFragment: ABaseListFragment<GameResult, RecyclerView.ViewHolder>(), ILobbyView {

    /*class Adapter : ABaseAdapter<GameResult, RecyclerView.ViewHolder>() {

        companion object {
            const val TYPE_LOBBY = 0
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            val view: View = TypeLobbyView(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            return object : RecyclerView.ViewHolder(view) {}
        }

        override fun getItemViewType(position: Int): Int {
            return TYPE_LOBBY
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = holder.itemView
            if (view is ITypeLobbyView)
                view.bind(data[position])
        }
    }*/
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

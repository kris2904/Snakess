package com.example.snakess.presention.credentials.createplay


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakess.R
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.routers.ICreategameRouter
import kotlinx.android.synthetic.main.fragment_create_game.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class CreateGameFragment : ABaseFragment(),ICreateGameView {
    //----------------------------
    val TAG = CreateGameFragment::class.java.simpleName
    @Inject
    @InjectPresenter
    lateinit var presentorCreateGame:CreateGamePresenter
    @ProvidePresenter
    fun providePresenter()=presentorCreateGame

    override fun inject() {
       DaggerAppComponent.create().inject(this)
    }
    override fun getViewId()=R.layout.fragment_create_game
    var add_remuv_players:Int=2
    //------------------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека

        bottonGame_start.setOnClickListener {
            val nameGame = "${name_game.text}"
            val kol_players = "${window_add_player.text}"

            if (nameGame.isEmpty()) {
                toast(stringId = R.string.error_nameGame)
                return@setOnClickListener
            }
            presentorCreateGame.creategame(nameGame, kol_players.toInt())
        }
        txt_add_player.setOnClickListener {

            if (add_remuv_players >=8) {
                toast(stringId = R.string.error_kol_bolshe_players)
                return@setOnClickListener
            }
            else{
                add_remuv_players+=1
                window_add_player.text = "${add_remuv_players}"
            }
        }

        txt_remuve_player.setOnClickListener {

            if (add_remuv_players <= 2) {

                toast(stringId = R.string.error_kol_menshe_players)
                return@setOnClickListener
            }
            else{
                add_remuv_players-=1
                window_add_player.text = "${add_remuv_players}"
            }
        }
    }

    override fun showError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun showLobby() {
       activity?.let {
            if (it is ICreategameRouter)
                it.showLoabby()
        }
    }

    override fun lock() {
     //   visibility(flBtnContainer)
    }

    override fun unlock() {
       // visibility(flBtnContainer, false)
    }




}

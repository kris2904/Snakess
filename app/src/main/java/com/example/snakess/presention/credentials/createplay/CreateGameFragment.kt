package com.example.snakess.presention.credentials.createplay


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakess.R
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.ICreategameRouter
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_create_game.*
import kotlinx.android.synthetic.main.fragment_menu.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class CreateGameFragment : ABaseFragment(),ICreateGameView {
    //----------------------------
    @Inject
    @InjectPresenter
    lateinit var presentorCreateGame:CreateGamePresenter
    @ProvidePresenter
    fun providePresenter()=presentorCreateGame

    override fun inject() {
       DaggerAppComponent.create().inject(this)
    }
    override fun getViewId()=R.layout.fragment_create_game
    //------------------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека

        bottonGame_start.setOnClickListener(){
            activity?.let {
                if (it is ICreategameRouter)
                    it.showLoabby()
            }
        }

    }

    override fun showError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
    override fun lock() {
        visibility(flBtnContainer)
    }

    override fun unlock() {
        visibility(flBtnContainer, false)
    }




}

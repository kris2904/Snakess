package com.example.snakess.domain.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import com.example.snakess.activitys.LoginActivity
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_menu.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment :  ABaseFragment(),IMenuView {
    @Inject
    @InjectPresenter
    lateinit var presenter:MenuPresenter
    @ProvidePresenter
    fun providePresenter() = presenter
    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId()=R.layout.fragment_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека

        bottonGame_off.setOnClickListener(){
            LoginActivity.show()
        }
    }

  override fun lock() {
      visibility(flBtnContainer)
  }

    override fun unlock() {
        visibility(flBtnContainer, false)
    }



}

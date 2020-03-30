package com.example.snakess.presention.credentials.loading


import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakess.R
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.ILoginRouter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class LoadingFragment : ABaseFragment(), ILoaderView {
    @Inject
    @InjectPresenter
    lateinit var presenterLoader: LoadingPresenter

    @ProvidePresenter
    fun providePresenter() = presenterLoader

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }


    override fun getViewId()=R.layout.fragment_loading
    override fun onLoadingComplete() {
        activity?.let{
            if(it is ILoginRouter)
                it.showAuth()
        }
    }
   /* override fun chackAuth():Boolean {
        val userFromBD = userRepository.fetchUser()
        if (userFromBD != null) {
            return true
            //viewState.showMenuFragment()
        } else {
            return false
            //viewState.showAuthActivity()
        }
    }*/


    //-------------------------------MVP--------------------------------------------------------
    /*override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }*/
    //-------------------------------Routing--------------------------------------------------------
    override fun showMenuFragment() {
        //(activity as IMainRouter).showMenuFragment()
    }

    override fun showAuthActivity() {
        //(activity as IMainRouter).showAuthActivity()
    }



}

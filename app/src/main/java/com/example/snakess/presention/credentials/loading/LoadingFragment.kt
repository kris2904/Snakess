package com.example.snakess.presention.credentials.loading


import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.snakess.R
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.routers.ILoginRouter
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


    override fun getViewId() = R.layout.fragment_loading


    //-------------------------------Routing--------------------------------------------------------

    override fun showAuth() {
        activity?.let {
            if (it is ILoginRouter)
                it.showAuth()
        }
    }
}

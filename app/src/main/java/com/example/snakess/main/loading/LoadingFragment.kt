package com.example.snakess.main.loading


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.example.snakess.R
import com.example.snakess.main.IMainRouter
import kotlinx.android.synthetic.main.fragment_loading.*

/**
 * A simple [Fragment] subclass.
 */
class LoadingFragment : MvpAppCompatFragment(), ILoaderView {

    @InjectPresenter
    lateinit var presenter: LoadingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loading, container, true)
    }

    //-------------------------------MVP--------------------------------------------------------
    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }
    //-------------------------------Routing--------------------------------------------------------
    override fun showMenuFragment() {
        (activity as IMainRouter).showMenuFragment()
    }

    override fun showAuthActivity() {
        (activity as IMainRouter).showAuthActivity()
    }

}

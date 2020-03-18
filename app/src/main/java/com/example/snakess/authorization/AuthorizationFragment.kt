package com.example.snakess.authorization


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import kotlinx.android.synthetic.main.fragment_authorization.*


/**
 * A simple [Fragment] subclass.
 */
class AuthorizationFragment : MvpAppCompatFragment(),IAurhView {

    @InjectPresenter
    lateinit var presentor:AuthPresentor
    @ProvidePresenter
    fun providePresentor()=AuthPresentor()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       btAuthorization.setOnClickListener(){
           presentor.authtorization(login = "${edLogin.text}", psss = "${edPassword.text}")
           this.findNavController().navigate(R.id.nav_graph_main)
       }
       //работает
       button_text_registration.setOnClickListener(){
           this.findNavController().navigate(R.id.nav_RegistrationFragment)
       }
    }

    override fun showError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun validation(login: String, pass: String) {
        TODO("Not yet implemented")
    }

    override fun loading() {
        TODO("Not yet implemented")
    }
}

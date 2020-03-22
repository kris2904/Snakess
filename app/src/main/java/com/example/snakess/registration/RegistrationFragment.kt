package com.example.snakess.registration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import com.example.snakess.domain.di.models.User
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.edLogin
import kotlinx.android.synthetic.main.fragment_registration.edPassword

/**
 * A simple [Fragment] subclass.
 */
class RegistrationFragment : MvpAppCompatFragment(),IRegistrationView {

    @InjectPresenter
    lateinit var presentorRegistration:RegistrationPresenter

    @ProvidePresenter
    fun providePresentor()=RegistrationPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // presentorRegistration.fetchUser()
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_text_authtorization.setOnClickListener(){

        }
        btRegistration.setOnClickListener(){
            presentorRegistration.registration(login = "${edLogin.text}", psss = "${edPassword.text}")}
        btRegistration.setOnClickListener(){

        }


    }

    override fun showError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    override fun validation(login: String, pass: String) {
        TODO("Not yet implemented")
    }

    override fun fetchUser(data: List<User>) {
        TODO("Not yet implemented")
    }

    override fun loading() {
        TODO("Not yet implemented")
    }


}

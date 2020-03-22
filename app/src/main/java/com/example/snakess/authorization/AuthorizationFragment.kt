package com.example.snakess.authorization


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import com.example.snakess.activitys.MainActivity
import kotlinx.android.synthetic.main.fragment_authorization.*


/**
 * A simple [Fragment] subclass.
 */
class AuthorizationFragment : MvpAppCompatFragment(),IAurhView {
    lateinit var button:Button
    lateinit var  mainActivity:MainActivity
   // -------------------------
    @InjectPresenter
    lateinit var presentor:AuthPresentor
    @ProvidePresenter
    fun providePresentor()=AuthPresentor()
//--------------------------------------
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_authorization, container, false)
}


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       btAuthorization.setOnClickListener(){
           presentor.authtorization(login = "${edLogin.text}", psss = "${edPassword.text}")
       }
       button_text_registration.setOnClickListener(){
           //button=findViewById(R.id.container_menu)a
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

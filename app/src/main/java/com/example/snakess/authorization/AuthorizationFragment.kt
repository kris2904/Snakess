package com.example.snakess.authorization


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.snakess.R
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_registration.*

/**
 * A simple [Fragment] subclass.
 */
class AuthorizationFragment : Fragment() {

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
           this.findNavController().navigate(R.id.nav_graph_main)
       }
       //работает
       button_text_registration.setOnClickListener(){
           this.findNavController().navigate(R.id.nav_RegistrationFragment)
       }
    }
}

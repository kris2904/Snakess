package com.example.snakess.presention.credentials.registration


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
import com.example.snakess.presention.ILoginRouter
import kotlinx.android.synthetic.main.fragment_authorization.*
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.edLogin
import kotlinx.android.synthetic.main.fragment_registration.edPassword
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class RegistrationFragment : ABaseFragment(),IRegistrationView {

    @Inject
    @InjectPresenter
    lateinit var presentorRegistration: RegistrationPresenter

    @ProvidePresenter
    fun providePresentor() = presentorRegistration


    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_registration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btRegistration.setOnClickListener() {
            val login = "${edLogin.text}" // "null"
            val pass = "${edPassword.text}"

            if (login.isEmpty() || pass.isEmpty()) {
                if(login.isEmpty())
                    toast(stringId=R.string.error_login_undefined)
                if (pass.isEmpty())
                    toast(stringId=R.string.error_pass_undefined)
                if(login.isEmpty() && pass.isEmpty())
                    toast(stringId=R.string.error_login_passwd_undefined)
                return@setOnClickListener
            }
            presentorRegistration.registration(login, pass)
            //presentorRegistration.registration("${edLogin.text}", "${edPassword.text}")
        }
        button_text_authtorization.setOnClickListener() {
            activity?.let {
                if (it is ILoginRouter)
                    it.showAuth()
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


    /*  override fun validation(login: String, pass: String) {
     TODO("Not yet implemented")
 }

 override fun fetchUser(data: List<User>) {
     TODO("Not yet implemented")
 }

 override fun loading() {
     TODO("Not yet implemented")
 }*/
}

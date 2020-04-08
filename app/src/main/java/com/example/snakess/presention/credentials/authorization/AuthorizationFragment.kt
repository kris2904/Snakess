package com.example.snakess.presention.credentials.authorization


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.snakess.R
import com.example.snakess.base.ABaseFragment
import com.example.snakess.domain.di.coponents.DaggerAppComponent
import com.example.snakess.presention.routers.ILoginRouter
import kotlinx.android.synthetic.main.fragment_authorization.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class AuthorizationFragment : ABaseFragment(),IAurhView {

    // -------------------------
    @Inject
    @InjectPresenter
    lateinit var presentorAuth: AuthPresentor

    @ProvidePresenter
    fun providePresentor() = presentorAuth

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_authorization

    //--------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btAuthorization.setOnClickListener {

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

            presentorAuth.authtorization(login, pass)
        }
        button_text_registration.setOnClickListener() {
            activity?.let {
                if (it is ILoginRouter)
                    it.showRegistration()
            }
        }
    }
    override fun lock() {
        visibility(flBtnContainer)
    }

    override fun unlock() {
        visibility(flBtnContainer, false)
    }

    override fun onSuccess() {
        toast("SUCCESS")
        // Отправить на главную форму
    }

    override fun showError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}

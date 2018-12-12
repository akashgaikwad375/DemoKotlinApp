package com.webwerks.demokotlinapp.views.login

import android.content.Intent
import com.webwerks.demokotlinapp.R
import com.webwerks.demokotlinapp.databinding.LoginActivityBinding
import com.webwerks.demokotlinapp.models.User
import com.webwerks.demokotlinapp.utils.Navigator
import com.webwerks.demokotlinapp.utils.USERNAME
import com.webwerks.demokotlinapp.utils.USER_EMAIL
import com.webwerks.demokotlinapp.utils.Utils
import com.webwerks.demokotlinapp.views.PreferenceManager
import com.webwerks.demokotlinapp.views.base.BaseActivity
import com.webwerks.demokotlinapp.views.base.BasePresenter


class LoginActivity : BaseActivity<LoginActivityBinding>(), LoginContract.View {

    private var presenter: LoginPresenter? = null
    private lateinit var pref: PreferenceManager

    private lateinit var mBinding: LoginActivityBinding

    override fun getContentView(): Int = R.layout.activity_login

    override fun initView(binding: LoginActivityBinding) {
        mBinding = binding
        binding.view = this
        presenter?.setView(this)
        pref = PreferenceManager(this)
    }

    override fun getPresenter(): BasePresenter {
        presenter = LoginPresenter()
        return presenter!!
    }


    fun doLogin() {
        if (Utils.isConnectedToInternet(this)) {
            if (!Utils.validateEditText(this, mBinding.edtEmail, "Email") &&
                    !Utils.validateEmail(this, mBinding.edtEmail) &&
                    !Utils.validateEditText(this, mBinding.edtPassword, "Password")) {
                presenter?.doLogin(mBinding.edtEmail.text.toString().trim(),
                        mBinding.edtPassword.text.toString().trim())
            }
        }
    }

    override fun onLoginSuccess(user: User) {
        pref.saveString(USER_EMAIL, user.email)
        pref.saveString(USERNAME, user.username)
        Navigator.getInstance().navigateToHome(this, user)
    }

    override fun onLoginFailure(errorMessage: String) {
    }

    override fun setListener() {
    }

    override fun intentData(intent: Intent) {}

}

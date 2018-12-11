package com.webwerks.demokotlinapp.views.login

import android.content.Intent
import android.widget.Toast
import com.webwerks.demokotlinapp.R
import com.webwerks.demokotlinapp.databinding.LoginActivityBinding
import com.webwerks.demokotlinapp.views.base.BaseActivity


class LoginActivity : BaseActivity<LoginActivityBinding>(), LoginContract.View {

    private var presenter: LoginPresenter? = null

    private lateinit var mBinding: LoginActivityBinding

    override fun getContentView(): Int = R.layout.activity_login

    override fun initView(binding: LoginActivityBinding) {
        mBinding = binding
        binding.view = this
        presenter = LoginPresenter(this)
    }

    fun doLogin() {
        presenter?.doLogin(mBinding.edtEmail.text.toString().trim(),
                mBinding.edtPassword.text.toString().trim())
    }

    override fun onLoginSuccess(successMessage: String) {
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailure(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun setListener() {
    }

    override fun intentData(intent: Intent) {}

}

package com.webwerks.demokotlinapp.views.home

import android.content.Intent
import com.webwerks.demokotlinapp.R
import com.webwerks.demokotlinapp.databinding.HomeActivityBinding
import com.webwerks.demokotlinapp.models.User
import com.webwerks.demokotlinapp.models.UserBindingModel
import com.webwerks.demokotlinapp.views.base.BaseActivity
import com.webwerks.demokotlinapp.views.base.BasePresenter
import com.webwerks.demokotlinapp.views.login.LoginPresenter

class HomeActivity : BaseActivity<HomeActivityBinding>() {

    private lateinit var presenter: LoginPresenter
    private lateinit var mBinding: HomeActivityBinding
    private var user: User? = null

    override fun getContentView(): Int = R.layout.activity_home

    override fun initView(binding: HomeActivityBinding) {
        mBinding = binding
        val model = UserBindingModel().apply {
            firstName = user!!.firstName
            lastName = user!!.lastName
            username = user!!.username
            modified = user!!.modified
            email = user!!.email
        }
        binding.user = model

        model.username = "ABC"
    }

    override fun setListener() {}

    override fun intentData(intent: Intent) {
        user = intent.getSerializableExtra("USER") as User
    }

    override fun getPresenter(): BasePresenter {
        presenter = LoginPresenter()
        return presenter
    }
}

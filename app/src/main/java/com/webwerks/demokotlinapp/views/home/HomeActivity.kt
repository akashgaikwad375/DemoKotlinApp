package com.webwerks.demokotlinapp.views.home

import android.content.Intent
import android.util.Log
import com.webwerks.demokotlinapp.R
import com.webwerks.demokotlinapp.databinding.HomeActivityBinding
import com.webwerks.demokotlinapp.models.User
import com.webwerks.demokotlinapp.models.UserBindingModel
import com.webwerks.demokotlinapp.views.base.BaseActivity
import com.webwerks.demokotlinapp.views.base.BasePresenter

class HomeActivity : BaseActivity<HomeActivityBinding>() {

    private lateinit var mBinding: HomeActivityBinding
    private var user: User? = null

    override fun getContentView(): Int = R.layout.activity_home

    override fun initView(binding: HomeActivityBinding) {
        mBinding = binding
        val model = UserBindingModel()
        binding.user = model

        model.apply {
            firstName = user!!.firstName
            lastName = user!!.lastName
            username = user!!.username
            modified = user!!.modified
            email = user!!.email
        }

        val demoString = "He has 212.35 amount.he got 68.35 ruppes.abc"
        val newString = StringBuffer()
        for (i in 0..(demoString.length - 2)) {
            newString.append(demoString[i])
            if (demoString[i].toString() == ".") {
                if (Character.isDigit(demoString[i + 1]))
                    continue
                else newString.append("\n")
            }
        }
        newString.append(demoString.last())
        val string = newString.toString().replace("\n ", "\n")
        Log.e("Old String::", demoString)
        Log.e("new String::", string)
    }

    override fun setListener() {}

    override fun intentData(intent: Intent) {
        user = intent.getSerializableExtra("USER") as User
    }

    override fun getPresenter(): BasePresenter? {
        return null
    }
}

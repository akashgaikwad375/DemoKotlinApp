package com.webwerks.demokotlinapp.views.login

import com.webwerks.demokotlinapp.views.base.BasePresenter
import com.webwerks.demokotlinapp.views.base.BaseView

interface LoginContract {

    interface Presenter: BasePresenter{
        fun doLogin(email: String, password: String)
    }

    interface View: BaseView{
        fun onLoginSuccess(successMessage: String)
        fun onLoginFailure(errorMessage: String)
    }
}
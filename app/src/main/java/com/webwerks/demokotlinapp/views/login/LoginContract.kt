package com.webwerks.demokotlinapp.views.login

import com.webwerks.demokotlinapp.views.base.BasePresenter

interface LoginContract {

    interface Presenter: BasePresenter{
        fun doLogin(email: String, password: String)
    }

    interface View{
        fun onLoginSuccess(successMessage: String)
        fun onLoginFailure(errorMessage: String)
    }
}
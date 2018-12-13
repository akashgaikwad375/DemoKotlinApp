package com.webwerks.demokotlinapp.views.login

import com.webwerks.demokotlinapp.models.User
import com.webwerks.demokotlinapp.views.base.BasePresenter
import com.webwerks.demokotlinapp.views.base.BaseView

interface LoginContract {

    interface Presenter: BasePresenter{
        fun doLogin(email: String, password: String)
    }

    interface View: BaseView{
        fun onLoginSuccess(user: User)
        fun onLoginFailure(errorMessage: String)
        fun showEmailErrorMessage(message: String)
        fun showPasswordErrorMessage(message: String)
    }
}
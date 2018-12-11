package com.webwerks.demokotlinapp.views.login

import com.webwerks.demokotlinapp.api.APIClient
import com.webwerks.demokotlinapp.api.APIInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {

    private lateinit var apiInterface: APIInterface

    init {
        apiInterface = APIClient.getClient().create(APIInterface::class.java)
    }

    override fun doLogin(email: String, password: String) {
        apiInterface.login(email, password).map { return@map it }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    run {
                        if (response.status == "200") {
                            view.onLoginSuccess(response.userMsg)
                        } else view.onLoginFailure(response.userMsg)
                    }
                }, {
                    view.onLoginFailure("ERROR")
                })
    }

    override fun onStart() {

    }

    override fun onPause() {
    }
}
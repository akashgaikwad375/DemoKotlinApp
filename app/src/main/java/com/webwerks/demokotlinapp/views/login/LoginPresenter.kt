package com.webwerks.demokotlinapp.views.login

import com.webwerks.demokotlinapp.api.APIClient
import com.webwerks.demokotlinapp.api.APIInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter : LoginContract.Presenter {

    private var view: LoginContract.View? = null
    private var apiInterface: APIInterface = APIClient.getClient().create(APIInterface::class.java)

    fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun doLogin(email: String, password: String) {
        view?.showLoading()
        apiInterface.login(email, password).map { return@map it }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    run {
                        view?.hideLoading()
                        if (response.status == "200") {
                            view?.onLoginSuccess(response.userMsg)
                        } else view?.onLoginFailure(response.userMsg)
                    }
                }, {
                    view?.hideLoading()
                    view?.onLoginFailure("ERROR")
                })
    }

    override fun onStart() {

    }

    override fun onDestroy() {
        view = null
    }
}
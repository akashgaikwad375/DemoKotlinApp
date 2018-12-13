package com.webwerks.demokotlinapp.views.login

import com.webwerks.demokotlinapp.api.APIClient
import com.webwerks.demokotlinapp.api.APIInterface
import com.webwerks.demokotlinapp.utils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter : LoginContract.Presenter {

    private var view: LoginContract.View? = null
    private var apiInterface: APIInterface = APIClient.getClient().create(APIInterface::class.java)
    private var disposable: Disposable? = null

    fun setView(view: LoginContract.View) {
        this.view = view
    }

    private fun validate(email: String, password: String): Boolean{
        if(!Utils.validateEditText(email)){
            view?.showEmailErrorMessage("Email is empty")
            return false
        }
        if(!Utils.validateEmail(email)){
            view?.showEmailErrorMessage("Invalid Email")
            return false
        }
        if(!Utils.validateEditText(password)){
            view?.showPasswordErrorMessage("Password is empty")
            return false
        }
        return true
    }

    override fun doLogin(email: String, password: String) {
        if(validate(email, password)){
            view?.showLoading()
            disposable = apiInterface.login(email, password).map { return@map it }.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        run {
                            view?.hideLoading()
                            view?.showMessage(response.userMsg)
                            if (response.status == "200") {
                                view?.onLoginSuccess(response.user)
                            } else view?.onLoginFailure(response.userMsg)
                        }
                    }, {
                        view?.hideLoading()
                        view?.showMessage("${it.stackTrace}")
                        view?.onLoginFailure("ERROR")
                    })
        }
    }

    override fun onStart() { }

    override fun onDestroy() {
        if(disposable != null && !disposable!!.isDisposed){
            disposable!!.dispose()
            disposable = null
        }
        view = null
    }
}
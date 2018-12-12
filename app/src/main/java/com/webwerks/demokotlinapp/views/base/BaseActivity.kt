package com.webwerks.demokotlinapp.views.base

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.webwerks.demokotlinapp.utils.ProgressDialog

abstract class BaseActivity<in T : ViewDataBinding> : AppCompatActivity(), BaseView {

    private lateinit var mBinding: T
    private var progressDialog: ProgressDialog? = null
    private var presenter: BasePresenter? = null

    abstract fun getContentView(): Int
    protected abstract fun initView(binding: T)
    protected abstract fun setListener()
    abstract fun intentData(intent: Intent)
    abstract fun getPresenter(): BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@BaseActivity, getContentView())
        presenter = getPresenter()
        intentData(intent)
        initView(mBinding)
        setListener()
    }

    override fun showLoading() {
        if(progressDialog!= null){
            progressDialog!!.showLoading()
        } else {
            progressDialog = ProgressDialog(this)
            progressDialog!!.showLoading()
        }
    }

    override fun hideLoading() {
        if(progressDialog!= null){
            progressDialog!!.dismissLoading()
        }
    }

    override fun onStart() {
        super.onStart()
        if (presenter != null)
            presenter!!.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            presenter!!.onDestroy()
            presenter = null
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}

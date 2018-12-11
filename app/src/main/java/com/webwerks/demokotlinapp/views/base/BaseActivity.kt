package com.webwerks.demokotlinapp.views.base

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import com.webwerks.demokotlinapp.R

abstract class BaseActivity<in T : ViewDataBinding> : AppCompatActivity() , BaseView{

    private lateinit var mBinding: T
    private lateinit var progressBar: ProgressBar

    abstract fun getContentView(): Int
    protected abstract fun initView(binding: T)
    protected abstract fun setListener()
    abstract fun intentData(intent: Intent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        progressBar = findViewById(R.id.progressbar)
        mBinding = DataBindingUtil.setContentView(this@BaseActivity, getContentView())
        intentData(intent)
        initView(mBinding)
        setListener()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}

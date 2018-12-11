package com.webwerks.demokotlinapp.views.base

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity<in T : ViewDataBinding> : AppCompatActivity() {

    private lateinit var mBinding: T

    abstract fun getContentView(): Int
    protected abstract fun initView(binding: T)
    protected abstract fun setListener()
    abstract fun intentData(intent: Intent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this@BaseActivity, getContentView())
        intentData(intent)
        initView(mBinding)
        setListener()
    }
}

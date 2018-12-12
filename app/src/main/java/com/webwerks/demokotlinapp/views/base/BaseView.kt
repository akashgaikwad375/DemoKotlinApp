package com.webwerks.demokotlinapp.views.base

interface BaseView {

    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String)
}
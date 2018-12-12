package com.webwerks.demokotlinapp.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.webwerks.demokotlinapp.R

class ProgressDialog(context: Context) : Dialog(context){

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_progress_loader, null)
        setContentView(view)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    fun showLoading(){
        show()
    }

    fun dismissLoading(){
        dismiss()
    }

}
package com.webwerks.demokotlinapp.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.text.TextUtils
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.webwerks.demokotlinapp.R

class Utils {

    companion object {

        fun isConnectedToInternet(activity: Activity): Boolean {
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return if (networkInfo == null) {
                Toast.makeText(activity, R.string.no_internet, Toast.LENGTH_SHORT).show()
                false
            } else {
                true
            }
        }

        fun validateEditText(context: Context?, editText: EditText, field: String): Boolean {
            if (TextUtils.isEmpty(editText.text.toString().trim())) {
                editText.requestFocus()
                editText.error = "$field is empty"
                if (context != null) {
                    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
                }
                return true
            }
            return false
        }

        fun validateEmail(context: Context?, editText: EditText): Boolean {
            if (!Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches()) {
                editText.requestFocus()
                if (context != null) {
                    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
                }
                return true
            }
            return false
        }
    }
}
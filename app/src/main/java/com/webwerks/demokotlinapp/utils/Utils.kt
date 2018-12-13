package com.webwerks.demokotlinapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.webwerks.demokotlinapp.R

class Utils {

    companion object {

        fun isConnectedToInternet(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return if (networkInfo == null) {
                Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show()
                false
            } else {
                true
            }
        }

        fun validateEditText(field: String): Boolean {
            if (TextUtils.isEmpty(field)) {
                return false
            }
            return true
        }

        fun validateEmail(email: String): Boolean {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                return false
            }
            return true
        }
    }
}
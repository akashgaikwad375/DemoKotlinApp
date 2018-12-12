package com.webwerks.demokotlinapp.utils

import android.content.Context
import android.content.Intent
import com.webwerks.demokotlinapp.models.User
import com.webwerks.demokotlinapp.views.home.HomeActivity

class Navigator private constructor() {

    companion object {

        private var instance: Navigator = Navigator()

        fun getInstance(): Navigator {
            return instance
        }
    }

    fun navigateToHome(context: Context, user: User) {
        context.startActivity(Intent(context, HomeActivity::class.java)
                .apply { putExtra("USER", user) })
    }
}
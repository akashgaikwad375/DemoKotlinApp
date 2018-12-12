package com.webwerks.demokotlinapp.views

import android.content.Context
import android.content.SharedPreferences
import com.webwerks.demokotlinapp.utils.PREF_NAME

class PreferenceManager(context: Context){

    private var pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        pref.edit().putString("TOKEN", token).apply()
    }

    fun getToken(): String {
        return pref.getString("TOKEN", "")
    }

    fun saveBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun saveString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return pref.getString(key, "")
    }

    fun saveInt(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }
}
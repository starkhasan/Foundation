package com.ali.covid_case.util

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    private const val NAME = "covid-cases"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    private const val SIGN_UP = "sign_up"
    private const val DAY = "day"
    private const val COUNTRY = "country"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isSignUp: Boolean
        get() = preferences.getBoolean(SIGN_UP, false)
        set(value) = preferences.edit {
            it.putBoolean(SIGN_UP, value)
        }

    var day: String?
        get() = preferences.getString(DAY,"")
        set(value) = preferences.edit {
            it.putString(DAY, value)
        }

    var country: String?
        get() = preferences.getString(COUNTRY,"")
        set(value) = preferences.edit {
            it.putString(COUNTRY, value)
        }
}
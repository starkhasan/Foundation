package com.ceryl.ceryl.util

import android.content.Context
import android.content.SharedPreferences

object Preferences {
    private const val NAME = "folloh"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    private const val LOGIN = "login"
    private const val SIGN_UP = "sign_up"
    private const val AUTH_TOKEN = "auth_token"
    private const val ADDRESS="address"
    private const val HOME_ADD="home_address"
    private const val PHONE="phone"
    private const val EMAIL="email"
    private const val IS_PET="is_pet"
    private const val PASSWORD="password"
    private const val REMEMBER="remember"
    private const val FORGOT="forgot"
    private const val AMOUNT="amount"
    private const val FULL_NAME="name"
    private const val PET_COUNT="pet_count"
    private const val HASH="hash"
    private const val DEVICE_TOKEN="device_token"
    private const val HOME_DIALOG="home_dialog"


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var email:String?
        get() = preferences.getString(EMAIL,"")
        set(value) = preferences.edit{
            it.putString(EMAIL,value)
        }

    var full_name:String?
        get() = preferences.getString(FULL_NAME,"")
        set(value) = preferences.edit{
            it.putString(FULL_NAME,value)
        }

    var isLogin: Boolean
        get() = preferences.getBoolean(LOGIN, false)
        set(value) = preferences.edit {
            it.putBoolean(LOGIN, value)
        }

    var isSignUp: Boolean
        get() = preferences.getBoolean(SIGN_UP, false)
        set(value) = preferences.edit {
            it.putBoolean(SIGN_UP, value)
        }
}
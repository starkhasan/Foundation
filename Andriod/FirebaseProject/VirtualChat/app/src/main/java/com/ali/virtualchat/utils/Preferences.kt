package com.ali.virtualchat.utils

import android.content.Context
import android.content.SharedPreferences


object Preferences {
    private const val PREF = "prefs"
    private const val MODE = Context.MODE_PRIVATE
    private const val SENDER = "SENDER"
    private const val RECEIVER = "RECEIVER"
    private const val USERID = "user_id"
    private const val PASSWORD = "password"
    private const val REMEMBERME = "rememberme"
    private const val IS_LOGIN = "is_login"
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREF,MODE)
    }

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var sender:String?
        get() = preferences.getString(SENDER,"")
        set(value) {
            preferences.editMe {
                it.putString(SENDER,value)
            }
        }

    var receiver:String?
        get() = preferences.getString(RECEIVER,"")
        set(value) {
            preferences.editMe {
                it.putString(RECEIVER,value)
            }
        }

    var userid:String?
        get() = preferences.getString(USERID,"")
        set(value) {
            preferences.editMe {
                it.putString(USERID,value)
            }
        }

    var password:String?
        get() = preferences.getString(PASSWORD,"")
        set(value) {
            preferences.editMe {
                it.putString(PASSWORD,value)
            }
        }

    var rememberme:Boolean
        get() = preferences.getBoolean(REMEMBERME,false)
        set(value) {
            preferences.editMe {
                it.putBoolean(REMEMBERME,value)
            }
        }

    var is_login:Boolean
        get() = preferences.getBoolean(IS_LOGIN,false)
        set(value) {
            preferences.editMe {
                it.putBoolean(IS_LOGIN,value)
            }
        }
}

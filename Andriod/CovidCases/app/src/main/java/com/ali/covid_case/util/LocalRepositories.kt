package com.ali.covid_case.util

import android.content.Context
import androidx.preference.PreferenceManager
import com.google.gson.Gson

class LocalRepositories {

    companion object {
        @Synchronized
        fun getAppUser(ctx: Context): AppUser? {
            val jsonString = PreferenceManager.getDefaultSharedPreferences(ctx).getString(Cv.PREF, "")
            return if ("" == jsonString)
                null
            else
                Gson().fromJson(jsonString, AppUser::class.java)
        }

        @Synchronized
        fun saveAppUser(ctx: Context, user: AppUser?) {
            val jsonString = Gson().toJson(user)
            val preferences = PreferenceManager.getDefaultSharedPreferences(ctx)
            val editor = preferences.edit()
            editor.putString(Cv.PREF, jsonString)
            editor.apply()
        }
    }
}
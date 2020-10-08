package com.ali.covid_case.network

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.ali.covid_case.app.ThisApp
import com.ali.covid_case.network.response.CountryResponse
import com.ali.covid_case.network.response.History.HistoryResponse
import com.ali.covid_case.util.AppUser
import com.ali.covid_case.util.Cv
import com.ali.covid_case.util.LocalRepositories
import com.ali.covid_case.util.Preferences

class ApiCallService : IntentService(Cv.SERVICE_NAME) {

    var appUser: AppUser? = null
    var api: Api? = null

    companion object {
        fun action(ctx: Context, action: String) {
            val intent = Intent(ctx, ApiCallService::class.java)
            intent.action = action
            ctx.startService(intent)
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        val action = intent!!.action
        api = ThisApp.getApi(this)
        appUser = LocalRepositories.getAppUser(this)
        if(Cv.ACTION_GET_COUNTRY == action){
            api?.getCountries()!!.enqueue(ApiCallBack<CountryResponse?>())
        }else if(Cv.ACTION_GET_HISTORY == action){
            api?.getHistory(Preferences.day,Preferences.country)!!.enqueue(ApiCallBack<HistoryResponse?>())
        }
    }
}
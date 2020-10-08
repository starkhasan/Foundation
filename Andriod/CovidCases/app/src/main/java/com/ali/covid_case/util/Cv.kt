package com.ali.covid_case.util

interface Cv {

    companion object{
        const val PREF="com.ali.covid_case.app_user"
        const val SERVICE_NAME="NetworkingService"
        const val BaseUrl = "https://covid-193.p.rapidapi.com/"
        //const val BaseUrl = "https://api.covid19api.com/"
        const val TIMEOUT="Something went wrong!"
        const val ACTION_LOGIN="login"
        const val ACTION_GET_COUNTRY = "get_countries"
        const val ACTION_GET_HISTORY = "get_history"
        const val PERMISSIONS_BUZZ_REQUEST = 0xABC
    }
}
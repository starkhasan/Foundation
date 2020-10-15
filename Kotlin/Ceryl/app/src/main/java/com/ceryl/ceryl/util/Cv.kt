package com.ceryl.ceryl.util

interface Cv {

    companion object{
        const val PREF="com.ceryl.ceryl.app_user"
        const val SERVICE_NAME="NetworkingService"
        const val BaseUrl = "http://192.168.43.15:80/api/ceryl/"
        const val TIMEOUT="Something went wrong!"
        const val ACTION_LOGIN="login"
        const val ACTION_SIGNUP = "sign_up"
        const val ACTION_IS_EXIST = "is_exist"
        const val ACTION_NEW_PASSWORD = "new_password"
        const val ACTION_PROFILE = "profile"
        const val ACTION_DELETE_USER = "delete"
        const val ACTION_UPDATE_PROFILE = "update_profile"
        const val ACTION_GET_ALL_COURSE = "all_course"
        const val PERMISSIONS_BUZZ_REQUEST = 0xABC
    }
}
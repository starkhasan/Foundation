package com.usl.usl.utils

interface Cv {

    val SERVICE_NAME: String
        get() = "NetworkingService"
    val TIMEOUT: String
        get() = "Something went wrong"
    val PREFS_APP_USER: String
        get()="com.usl.app_user"
    val BASE_URL: String
        get() = "http://68.183.92.181:3000/"
    val ACTION_LOGIN: String
        get()="login"
    val ACTION_SENDSHEET: String
        get()="sheet"
    val ACTION_UPCOMINGGAME: String
        get()="upcoming_game"
    val ACTION_GETSHEETS: String
        get() = "get_sheet"
    val ACTION_SHEETCOLLECTION: String
        get() = "sheet_collection"
    val ACTION_UPDATESHEET: String
        get() = "update_sheet"
    val ACTION_MATCHEDBET: String
        get() = "matched_bet"
    val ACTION_SHEETDELETE:String
        get() = "sheets_delete"
    val ACTION_RESETPASSWORD: String
        get() = "reset_password"
    val ACTION_ACCOUNT: String
        get() = "account"
    val ACTION_HISTORY: String
        get() = "history"
}

/* http://68.183.92.181:3000/  Testing Server*/
/* http://192.168.1.19:3000/ Local Server */
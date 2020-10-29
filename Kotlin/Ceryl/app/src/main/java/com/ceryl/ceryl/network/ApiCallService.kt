package com.ceryl.ceryl.network

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.ceryl.ceryl.app.ThisApp
import com.ceryl.ceryl.network.response.GeneralResponse
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.network.response.course.AllCourseResponse
import com.ceryl.ceryl.network.response.course_content.CourseContentResponse
import com.ceryl.ceryl.network.response.profile.ProfileResponse
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.LocalRepositories
import com.ceryl.ceryl.util.Preferences

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
        appUser = LocalRepositories.getAppUser(applicationContext)
        if(Cv.ACTION_LOGIN == action){
            api?.login(appUser!!.logindata)!!.enqueue(ApiCallBack<UserResponse?>())
        }else if(Cv.ACTION_SIGNUP == action){
            api?.signup(appUser!!.signup)!!.enqueue(ApiCallBack<UserResponse?>())
        }else if(Cv.ACTION_IS_EXIST == action){
            api?.is_exist(appUser!!.email)!!.enqueue(ApiCallBack<UserResponse?>())
        }else if(Cv.ACTION_NEW_PASSWORD == action){
            api?.new_password(appUser!!.new_password)!!.enqueue(ApiCallBack<UserResponse?>())
        }else if(Cv.ACTION_PROFILE == action){
            api?.getProfile(appUser!!.logindata)!!.enqueue(ApiCallBack<ProfileResponse?>())
        }else if(Cv.ACTION_DELETE_USER == action){
            api?.delete_user(appUser!!.email)!!.enqueue(ApiCallBack<UserResponse?>())
        }else if(Cv.ACTION_UPDATE_PROFILE == action){
            api?.update_profile(appUser!!.profileUpdate)!!.enqueue(ApiCallBack<GeneralResponse?>())
        }else if(Cv.ACTION_GET_ALL_COURSE == action){
            api?.get_all_course(Preferences.email.toString())!!.enqueue(ApiCallBack<AllCourseResponse?>())
        }else if(Cv.ACTION_COURSE_CONTENT == action){
            api?.course_content(appUser!!.course_content)!!.enqueue(ApiCallBack<CourseContentResponse?>())
        }
    }
}
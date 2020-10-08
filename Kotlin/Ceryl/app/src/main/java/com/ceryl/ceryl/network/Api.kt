package com.ceryl.ceryl.network

import com.ceryl.ceryl.network.response.GeneralResponse
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.network.response.course.AllCourseResponse
import com.ceryl.ceryl.network.response.profile.ProfileResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("user/readuser.php")
    fun getUser(): Call<UserResponse>?
    @POST("user/login.php")
    fun login(@Body map : HashMap<String,Any>): Call<UserResponse>?
    @POST("user/createuser.php")
    fun signup(@Body map : HashMap<String,Any>): Call<UserResponse>?
    @POST("user/user_avail.php")
    fun is_exist(@Body map:HashMap<String,Any>): Call<UserResponse>?
    @POST("user/new_password.php")
    fun new_password(@Body map: HashMap<String, Any>): Call<UserResponse>?
    @POST("user/user_profile.php")
    fun getProfile(@Body map: HashMap<String,Any>): Call<ProfileResponse>?
    @DELETE("user/delete.php/{email}")
    fun delete_user(@Path("email") email:String):Call<UserResponse>?
    @POST("user/profileUpgrade.php")
    fun update_profile(@Body map:HashMap<String,Any>):Call<GeneralResponse>?
    @GET("course/all_course.php")
    fun get_all_course(): Call<AllCourseResponse>?
}
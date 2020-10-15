package com.ceryl.ceryl.network

import com.ceryl.ceryl.network.response.GeneralResponse
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.network.response.course.AllCourseResponse
import com.ceryl.ceryl.network.response.profile.ProfileResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("Users/readuser.php")
    fun getUser(): Call<UserResponse>?
    @POST("Users/login.php")
    fun login(@Body map : HashMap<String,Any>): Call<UserResponse>?
    @POST("Users/signup.php")
    fun signup(@Body map : HashMap<String,Any>): Call<UserResponse>?
    @POST("Users/user_avail.php")
    fun is_exist(@Query("email") email:String): Call<UserResponse>?
    @POST("Users/forgot_password.php")
    fun new_password(@Body map: HashMap<String, Any>): Call<UserResponse>?
    @POST("Users/user_profile.php")
    fun getProfile(@Body map: HashMap<String,Any>): Call<ProfileResponse>?
    @DELETE("Users/delete.php")
    fun delete_user(@Query("email") email:String):Call<UserResponse>?
    @POST("Users/profileUpdate.php")
    fun update_profile(@Body map:HashMap<String,Any>):Call<GeneralResponse>?
    @GET("Courses/all_course.php")
    fun get_all_course(): Call<AllCourseResponse>?
}
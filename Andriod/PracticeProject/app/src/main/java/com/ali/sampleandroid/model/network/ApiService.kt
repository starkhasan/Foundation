package com.ali.sampleandroid.model.network
import com.ali.sampleandroid.model.response.UserCommentResponse
import com.ali.sampleandroid.model.response.UserResponse
import com.ali.sampleandroid.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {
    @GET("/posts")
    fun getUser(): Call<List<UserResponse>>
    //URL MANIPULATION
    //a request URL can be updated dynamically using replacement blocks and parameters on the method.a replacement block is an alphanumeric string surrounded by { and }
    @GET("/posts/{id}")
    fun getUserPost(@Path("id") id: Int): Call<UserResponse>
    //For Query Parameter
    @GET("/comments")
    fun getSingleComment(@Query("postId") postId: Int): Call<List<UserCommentResponse>>
    //Example of POST Request
    @POST("/posts")
    fun postNewUser(@Body user: HashMap<String, Any>) : Call<UserResponse>
    @PUT("/posts/{id}")
    fun updateUser(@Body user: HashMap<String, Any>, @Path("id") id: Int) : Call<UserResponse>

    companion object {
        fun retroClient() : ApiService {
            //HttpLoggingInterceptor
            val logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
            //OkhttpClient
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
            //Retrofit
            val client = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient.build())
                .build()
            return client.create(ApiService::class.java)
        }
    }
}
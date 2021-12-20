package com.ali.sampleandroid.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.sampleandroid.R
import com.ali.sampleandroid.adapter.UserDetailsAdapter
import com.ali.sampleandroid.databinding.ActivityHttpOperationBinding
import com.ali.sampleandroid.model.network.ApiService
import com.ali.sampleandroid.model.response.UserResponse
import retrofit2.Call
import retrofit2.Response

class HTTPOperationActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var activityLayout : ActivityHttpOperationBinding
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var userDetailsAdapter: UserDetailsAdapter
    private var listUser = ArrayList<UserResponse>()
    val client = ApiService.retroClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLayout = ActivityHttpOperationBinding.inflate(LayoutInflater.from(this))
        setContentView(activityLayout.root)
        activityLayout.btnCallAPI.setOnClickListener(this)
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        activityLayout.rvUser.layoutManager = linearLayoutManager

        userDetailsAdapter = UserDetailsAdapter(listUser){ position: Int ->
            Toast.makeText(applicationContext,"${listUser[position]} clicked",Toast.LENGTH_SHORT).show()
        }
        activityLayout.rvUser.adapter = userDetailsAdapter
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnCallAPI -> {
                if(checkConnection()) {
                    activityLayout.tvNoContent.visibility = View.GONE
                    activityLayout.progressBar.visibility = View.VISIBLE
                    /*
                    *Get request withotut id
                    client.getUser().enqueue(object : retrofit2.Callback<List<UserResponse>> {
                        override fun onResponse(call: Call<List<UserResponse>>, response: Response<List<UserResponse>>) {
                            activityLayout.tvNoContent.visibility = View.GONE
                            activityLayout.progressBar.visibility = View.GONE
                            if (response.body() != null) {
                                listUser.clear()
                                listUser.addAll(response.body() as ArrayList<UserResponse>)
                                userDetailsAdapter.notifyDataSetChanged()
                            }
                        }

                        override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                            activityLayout.progressBar.visibility = View.GONE
                            activityLayout.tvNoContent.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    })
                    */

                    /*
                    *Example of URL Manipulation
                    client.getUserPost(1).enqueue(object: retrofit2.Callback<UserResponse>{
                        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                            activityLayout.tvNoContent.visibility = View.GONE
                            activityLayout.progressBar.visibility = View.GONE
                            if(response.body() != null){
                                listUser.clear()
                                listUser.add(response.body() as UserResponse)
                                userDetailsAdapter.notifyDataSetChanged()
                            }
                        }

                        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                            activityLayout.progressBar.visibility = View.GONE
                            activityLayout.tvNoContent.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    })
                    */


                    /*Example of GET Query Paramter
                    client.getSingleComment(1).enqueue(object: retrofit2.Callback<List<UserCommentResponse>>{
                        override fun onResponse(call: Call<List<UserCommentResponse>>, response: Response<List<UserCommentResponse>>) {
                            activityLayout.tvNoContent.visibility = View.GONE
                            activityLayout.progressBar.visibility = View.GONE
                            if(response.body() != null){
                                listUser.clear()
                                listUser.addAll(response.body() as List<UserCommentResponse>)
                                userDetailsAdapter.notifyDataSetChanged()
                            }
                        }

                        override fun onFailure(call: Call<List<UserCommentResponse>>, t: Throwable) {
                            activityLayout.progressBar.visibility = View.GONE
                            activityLayout.tvNoContent.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                        }

                    })
                    */

                    /*
                    * POST Request Example creating new user type
                    val newUser = hashMapOf<String,Any>(
                        "title" to "foo",
                        "body" to "Ali Hasan",
                        "userId" to 1
                    )
                    client.postNewUser(newUser).enqueue(object : retrofit2.Callback<UserResponse>{
                        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                            activityLayout.tvNoContent.visibility = View.GONE
                            activityLayout.progressBar.visibility = View.GONE
                            if(response.body() != null){
                                listUser.clear()
                                listUser.add(response.body() as UserResponse)
                                userDetailsAdapter.notifyDataSetChanged()
                            }
                        }

                        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                            activityLayout.progressBar.visibility = View.GONE
                            activityLayout.tvNoContent.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    })
                    */


                    //PUT Example // Used to update the data
                    val newUser = hashMapOf<String,Any>(
                            "id" to 1,
                            "title" to "Software Engineer",
                            "body" to "Ali Hasan",
                            "userId" to 1
                    )
                    client.updateUser(newUser,1).enqueue(object : retrofit2.Callback<UserResponse>{
                        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                            activityLayout.tvNoContent.visibility = View.GONE
                            activityLayout.progressBar.visibility = View.GONE
                            if(response.body() != null){
                                listUser.clear()
                                listUser.add(response.body() as UserResponse)
                                userDetailsAdapter.notifyDataSetChanged()
                            }
                        }

                        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                            activityLayout.progressBar.visibility = View.GONE
                            activityLayout.tvNoContent.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                        }
                    })

                }else Toast.makeText(applicationContext,"No Internet Connection",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkConnection() : Boolean{
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val networkInfo =  connectivityManager.activeNetwork ?: return false
            val actNetwork = connectivityManager.getNetworkCapabilities(networkInfo)!!
            return when{
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }else{
            connectivityManager.allNetworks.forEach{ network ->
                val networkInfo = connectivityManager.getNetworkInfo(network)
                return (networkInfo!!.type == ConnectivityManager.TYPE_WIFI || networkInfo.type == ConnectivityManager.TYPE_MOBILE) && networkInfo.isConnectedOrConnecting
            }
        }
        return false
    }

}
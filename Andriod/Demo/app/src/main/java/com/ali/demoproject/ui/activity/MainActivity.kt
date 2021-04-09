package com.ali.demoproject.ui.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.ali.demoproject.R
import com.ali.demoproject.model.UserModel
import com.ali.demoproject.network.Api
import com.ali.demoproject.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),View.OnClickListener{

    var api:Api?=null
    var listUser : List<UserModel> ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvHeading.text = "Demo Project"
        ivNav.visibility = View.VISIBLE
        ivNav.setOnClickListener(this)
        llAppLifeCycle.setOnClickListener(this)
        llViewPager.setOnClickListener(this)
        llApiChecking.setOnClickListener(this)
        val gridLayoutManager  =  GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        rvUsers.layoutManager = gridLayoutManager
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(Api::class.java)
        _callApi()
    }

    fun _callApi(){
        val call = api!!.getUser()
        call!!.enqueue(object: Callback<List<UserModel>>{
            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
                if(response.isSuccessful){
                    progressbar.visibility = View.GONE
                    listUser = response.body()
                    rvUsers.adapter = UserAdapter(this@MainActivity,listUser){ position:Int,OPERATION:String ->
                        if (OPERATION ==  "Click")
                            Toast.makeText(applicationContext,position.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.ivNav -> {
                if(drawer_layout.isDrawerOpen(GravityCompat.START))
                    drawer_layout.closeDrawer(GravityCompat.START)
                else
                    drawer_layout.openDrawer(GravityCompat.START)
            }
            R.id.llAppLifeCycle -> {
                startActivity(Intent(this,AppLifeCycleActivity::class.java))
            }
            R.id.llViewPager -> {
                startActivity(Intent(this,ViewPagerActivity::class.java))
            }
            R.id.llApiChecking -> {
                startActivity(Intent(this,ApiCheckingActivity::class.java))
            }
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to Exit?")
                .setPositiveButton("Ok") { dialog: DialogInterface, int: Int ->
                    super.onBackPressed()
                }
                .setNegativeButton("No") { dialog: DialogInterface, _: Int ->
                    dialog.dismiss()
                }
                .show()
    }
}
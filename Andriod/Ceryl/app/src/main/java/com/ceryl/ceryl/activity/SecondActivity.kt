package com.ceryl.ceryl.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceryl.ceryl.R
import com.ceryl.ceryl.adapter.PositionAdapter
import com.facebook.*
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_second.*
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList


class SecondActivity : AppCompatActivity() {

    private val EMAIL = "email"
    lateinit var callbackManager : CallbackManager
    var listName = ArrayList<String>()
    lateinit var linearLayoutManager:LinearLayoutManager
    lateinit var positionAdapter:PositionAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var spinnerAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,resources.getStringArray(R.array.country))
        spinner.adapter=spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext,"Nothing is Selected",Toast.LENGTH_SHORT).show()
            }
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext,parent?.getItemAtPosition(p2).toString(),Toast.LENGTH_SHORT).show()
            }
        }

        btnTHird.setOnClickListener {
            startActivity(Intent(this,ThirdActivity::class.java))
        }

        /*lidtview.adapter =  ArrayAdapter(this,R.layout.layout_row,R.id.tvList,resources.getStringArray(R.array.country))
        lidtview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(applicationContext,selectedItem,Toast.LENGTH_SHORT).show()
        }*/

        for(i in 0..14){
            listName.add(i.toString())
        }

        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvPosition.layoutManager=linearLayoutManager

        positionAdapter = PositionAdapter(this,listName)
        rvPosition.adapter = positionAdapter




//        val accessToken = AccessToken.getCurrentAccessToken()
//        val isLoggedIn = accessToken != null && !accessToken.isExpired
//
//        if(isLoggedIn){
//            Toast.makeText(applicationContext,"Already Login",Toast.LENGTH_SHORT).show()
//            getUserInfo(accessToken)
//        }

        /*
        Code for Getting the Hash key for Facebook
        var info: PackageInfo
        try {
            info = packageManager.getPackageInfo("com.ceryl.ceryl",PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                var md : MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val something = String(Base64.getEncoder().encode(md.digest()))
                Log.v("Hash Key", something)
            }
        } catch (e1: PackageManager.NameNotFoundException) {
            Log.e("Name Not Found", e1.toString())
        } catch (e: NoSuchAlgorithmException) {
            Log.e("No Such an Algorithm", e.toString())
        } catch (e: Exception) {
            Log.e("Exception", e.toString())
        }
        */


        callbackManager = CallbackManager.Factory.create();

        login_button.setReadPermissions(Arrays.asList(EMAIL))
        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) {
                Log.v("Facebook", "login")
                getUserInfo(loginResult!!.accessToken)
            }
            override fun onCancel() {
                Log.v("Facebook", "on cancel")
            }
            override fun onError(exception: FacebookException) {
                Log.v("Facebook", "somthing went worng")
            }
        })
    }

    fun getUserInfo(token:AccessToken){
        val request = GraphRequest.newMeRequest(token) { `object`: JSONObject, response : GraphResponse->
            var id = `object`.getString("id")
        }
        val parameters = Bundle()
        parameters.putString("fields", "id")
        request.parameters = parameters
        request.executeAsync()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
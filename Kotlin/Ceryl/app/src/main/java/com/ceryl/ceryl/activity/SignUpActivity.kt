package com.ceryl.ceryl.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.ceryl.ceryl.R
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.network.ApiCallService
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.util.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.greenrobot.eventbus.Subscribe

class SignUpActivity : RegisterAbstractActivity() {

    var appUser = AppUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)

        tvLogin.setOnClickListener{
            startActivity(Intent(SignUpActivity@this,LoginActivity::class.java))
        }

        rlSignUp.setOnClickListener {
            Helper.hideKeyboard(SignUpActivity@this)
            if(validation()){
                if(ConnectivityReceiver().isConnected()){
                    rotateloading.start()
                    appUser.signup.clear()
                    appUser?.signup.put("first_name",etFirstName.text.toString())
                    appUser?.signup.put("last_name",etLastName.text.toString())
                    appUser?.signup.put("email",etEmail.text.toString())
                    appUser?.signup.put("password",etPassword.text.toString())
                    LocalRepositories.saveAppUser(this,appUser)
                    ApiCallService.action(this,Cv.ACTION_SIGNUP)
                }else{
                    Helper.snackbar_alert(SignUpActivity@this,getString(R.string.no_internet_connection),rlSignupParent)
                }
            }
        }
    }

    @Subscribe
    fun signup(response:UserResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.status == 200){
            Toast.makeText(applicationContext,response.message,Toast.LENGTH_SHORT).show()
            Preferences.full_name = etFirstName.text.toString()+" "+etLastName.text.toString()
            Preferences.email = etEmail.text.toString()
            Preferences.isLogin = true
            startActivity(Intent(SignUpActivity@this,HomeActivity::class.java))
            finish()
        }
        Helper.snackbar_info(SignUpActivity@this,response.message,rlSignupParent)
    }

    private fun validation():Boolean{
        if(TextUtils.isEmpty(etFirstName.text)){
            Helper.snackbar_alert(SignUpActivity@this,"Please provide first name",rlSignupParent)
            return false
        }else if(TextUtils.isEmpty(etLastName.text)){
            Helper.snackbar_alert(SignUpActivity@this,"Please provide last name",rlSignupParent)
            return false
        }else if(TextUtils.isEmpty(etEmail.text)){
            Helper.snackbar_alert(SignUpActivity@this,"Please provide email",rlSignupParent)
            return false
        }else if(TextUtils.isEmpty(etPassword.text)){
            Helper.snackbar_alert(SignUpActivity@this,"Please provide password",rlSignupParent)
            return false
        }else if(etPassword.text.length < 5){
            Helper.snackbar_alert(SignUpActivity@this,"Length of password must have five or more",rlSignupParent)
            return false
        }
        return true;
    }

    override fun layoutId(): Int {
        return R.layout.activity_signup
    }

    @Subscribe
    fun timeout(msg: String) {
        if (rotateloading.isStart) {
            rotateloading.stop()
        }
        Helper.snackbar_alert(SignUpActivity@this,Cv.TIMEOUT,rlSignupParent)
    }
}
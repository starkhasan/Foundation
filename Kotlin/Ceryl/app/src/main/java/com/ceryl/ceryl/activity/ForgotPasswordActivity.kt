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
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Helper
import com.ceryl.ceryl.util.LocalRepositories
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_forgot_password.etEmail
import kotlinx.android.synthetic.main.activity_forgot_password.rotateloading
import kotlinx.android.synthetic.main.activity_forgot_password.tvSignup
import kotlinx.android.synthetic.main.activity_login.*
import org.greenrobot.eventbus.Subscribe

class ForgotPasswordActivity : RegisterAbstractActivity() {

    var appUser = AppUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)

        tvSignup.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        rlForgotPassword.setOnClickListener {
            Helper.hideKeyboard(ForgotPasswordActivity@this)
            if(validation()){
                if(ConnectivityReceiver().isConnected()){
                    rotateloading.start()
                    appUser.isExist.put("email",etEmail.text.toString())
                    LocalRepositories.saveAppUser(this,appUser)
                    ApiCallService.action(applicationContext,Cv.ACTION_IS_EXIST)
                }else{
                    Helper.snackbar_alert(ForgotPasswordActivity@this,getString(R.string.no_internet_connection),rlParentForgot)
                }
            }
        }
    }

    @Subscribe
    fun isExist(response: UserResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.status == 200){
            val intent = Intent(ForgotPasswordActivity@this,NewPasswordActivity::class.java)
            intent.putExtra("Email",etEmail.text.toString())
            startActivity(intent)
        }else{
            Helper.snackbar_alert(ForgotPasswordActivity@this,response.message,rlParentForgot)
        }
    }

    fun validation() : Boolean{
        if(TextUtils.isEmpty(etEmail.text)){
            Helper.snackbar_alert(ForgotPasswordActivity@this,"Please provide email",rlParentForgot)
            return false
        }
        return true
    }
    override fun layoutId(): Int {
        return R.layout.activity_forgot_password
    }

    @Subscribe
    fun timeout(msg: String) {
        if (rotateloading.isStart) {
            rotateloading.stop()
        }
        Helper.snackbar_alert(ForgotPasswordActivity@this,Cv.TIMEOUT,rlParentForgot)
    }
}
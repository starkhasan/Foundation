package com.ceryl.ceryl.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.ceryl.ceryl.R
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.network.ApiCallService
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Helper
import com.ceryl.ceryl.util.LocalRepositories
import kotlinx.android.synthetic.main.activity_newpassword.*
import kotlinx.android.synthetic.main.activity_newpassword.rotateloading
import org.greenrobot.eventbus.Subscribe


class NewPasswordActivity : RegisterAbstractActivity() {

    var appUser = AppUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)
        var isVisible = false
        var isVisible_second = false
        tvUserEmail.text = intent.getStringExtra("Email")

        rlNewPassword.setOnClickListener {
            Helper.hideKeyboard(NewPasswordActivity@this)
            if(validation()){
                if(ConnectivityReceiver().isConnected()){
                    rotateloading.start()
                    appUser?.new_password?.put("email",tvUserEmail.text.toString())
                    appUser?.new_password?.put("password",etConfirmPassword.text.toString())
                    LocalRepositories.saveAppUser(applicationContext,appUser)
                    ApiCallService.action(applicationContext,Cv.ACTION_NEW_PASSWORD)
                }else{
                    Helper.snackbar_alert(NewPasswordActivity@this,getString(R.string.no_internet_connection),rlNewPasswordParent)
                }
            }
        }

        ivShow.setOnClickListener {
            if(isVisible){
                isVisible = false
                etNewPassword.setTransformationMethod(PasswordTransformationMethod())
                ivShow.setImageResource(R.drawable.icon_show)
            }else{
                isVisible = true
                ivShow.setImageResource(R.drawable.icon_hide)
                etNewPassword.transformationMethod = null
            }
        }

        ivConfPass.setOnClickListener {
            if(isVisible_second){
                isVisible_second = false
                etConfirmPassword.setTransformationMethod(PasswordTransformationMethod())
                ivConfPass.setImageResource(R.drawable.icon_show)
            }else{
                isVisible_second = true
                ivConfPass.setImageResource(R.drawable.icon_hide)
                etConfirmPassword.transformationMethod = null
            }
        }
    }

    @Subscribe
    fun new_password(response:UserResponse){
        if (rotateloading.isStart) {
            rotateloading.stop()
        }
        if(response.status == 200){
            etConfirmPassword.setText("")
            etNewPassword.setText("")
            val intent = Intent(NewPasswordActivity@this,HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }
        Helper.snackbar_info(NewPasswordActivity@this,response.message,rlNewPasswordParent)
    }

    fun validation() : Boolean{
        if(TextUtils.isEmpty(etNewPassword.text)){
            Helper.snackbar_alert(NewPasswordActivity@this,"Please provide valid password",rlNewPasswordParent)
            return false
        }else if(etNewPassword.text.length < 5){
            Helper.snackbar_alert(NewPasswordActivity@this,"Length of password must have five or more",rlNewPasswordParent)
            return false
        }else if(TextUtils.isEmpty(etConfirmPassword.text)){
            Helper.snackbar_alert(NewPasswordActivity@this,"Please provide valid password",rlNewPasswordParent)
            return false
        }else if(etConfirmPassword.text.length < 5){
            Helper.snackbar_alert(NewPasswordActivity@this,"Length of pass must have five or more",rlNewPasswordParent)
            return false
        }else if(etNewPassword.text.toString() != etConfirmPassword.text.toString()){
            Helper.snackbar_alert(NewPasswordActivity@this,"Password doesn't matches",rlNewPasswordParent)
            return false
        }
        return true
    }

    override fun layoutId(): Int {
        return R.layout.activity_newpassword
    }


    @Subscribe
    fun timeout(msg: String) {
        if (rotateloading.isStart) {
            rotateloading.stop()
        }
        Helper.snackbar_alert(NewPasswordActivity@this,Cv.TIMEOUT,rlNewPasswordParent)
    }
}
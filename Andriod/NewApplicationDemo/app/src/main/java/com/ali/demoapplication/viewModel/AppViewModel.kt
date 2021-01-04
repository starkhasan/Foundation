package com.ali.demoapplication.viewModel

import android.text.TextUtils
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.ali.demoapplication.BR
import com.ali.demoapplication.model.Model


class AppViewModel(var model: Model = Model("", 0)) : BaseObservable() {


    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    @Bindable
    private var toastMessage: String? = null

    fun getToastMessage(): String? {
        return toastMessage
    }

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getUserEmail(): String? {
        return model.email
    }

    fun setUserEmail(email: String) {
        model.email = email
        notifyPropertyChanged(BR.userEmail)
    }

    @Bindable
    fun getUserPassword(): Int? {
        return model.password
    }

    fun setUserPassword(password: Int?) {
        model.password = password!!
        notifyPropertyChanged(BR.userPassword)
    }


    fun onButtonClicked() {
        if (isValid()) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    fun isValid(): Boolean {
        if(TextUtils.isEmpty(getUserEmail())){
            return false
        }else if(TextUtils.isEmpty(getUserPassword().toString())){
            return false
        }
        return true
    }
}
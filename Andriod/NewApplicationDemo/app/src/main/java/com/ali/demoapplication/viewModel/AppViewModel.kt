package com.ali.demoapplication.viewModel

import android.text.TextUtils
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ali.demoapplication.BR


data class AppViewModel(
    private var _email: String,
    private var _password: Int
) : BaseObservable() {

    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    var email: String
        @Bindable get() = _email
        set(value) {
            _email = value
            notifyPropertyChanged(BR.email)
        }

    var password: Int
        @Bindable get() = _password
        set(value) {
            _password = value
            notifyPropertyChanged(BR.password)
        }

    fun onButtonClicked() {

    }

    fun isValid(): Boolean {
        if(TextUtils.isEmpty(email)){
            return false
        }else if(TextUtils.isEmpty(password.toString())){
            return false
        }
        return true
    }


}
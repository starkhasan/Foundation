package com.ceryl.ceryl.network

import com.ceryl.ceryl.util.Cv
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCallBack<T> : Callback<T> {

    private var t: T? = null
    fun apiCallBack(t: T) {
        this.t = t
    }

    override fun onResponse(call: Call<T>?, response: Response<T>) {
        if (response.code() == 200) {
            val body: T? = response.body()
            EventBus.getDefault().post(body)
        } else {
            EventBus.getDefault().post(Cv.TIMEOUT)
        }
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        EventBus.getDefault().post(Cv.TIMEOUT)
    }
}
package com.ali.virtualchat.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.util.Base64
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import java.io.ByteArrayOutputStream


class Helper {

    companion object{
        fun hideKeyboard(activity: Activity) {
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view: View? = activity.currentFocus
            if (view == null)
                view = View(activity)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }

        fun base64toImage(base64: String): Bitmap {
            val imageBytes = Base64.decode(base64, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            return decodedImage
        }

        fun imagetobase64(bitmap: Bitmap):String{
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream)
            val byteArray = byteArrayOutputStream.toByteArray()
            val base64 = Base64.encodeToString(byteArray, Base64.DEFAULT)
            return base64
        }

        fun isNetworkConnected(context: Context):Boolean{
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm!!.activeNetworkInfo != null && cm!!.activeNetworkInfo!!.isConnected
        }

    }
}
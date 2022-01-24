package com.ceryl.ceryl.util

import android.R.attr.bitmap
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ceryl.ceryl.R
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream


class Helper {
    companion object{
        fun snackbar_info(context:Context,message:String,parent_activity:RelativeLayout) {
            val snack = Snackbar.make(parent_activity,message, Snackbar.LENGTH_SHORT)
            val view = snack.view
            val textView = view.findViewById<TextView>(R.id.snackbar_text)
            textView.setTextColor(ContextCompat.getColor(context, R.color.white))
            snack.show()
        }


        fun snackbar_alert(context:Context,message:String,parent_activity:RelativeLayout) {
            val snack = Snackbar.make(parent_activity,message, Snackbar.LENGTH_SHORT)
            val view = snack.view
            val textView = view.findViewById<TextView>(R.id.snackbar_text)
            textView.setTextColor(ContextCompat.getColor(context, R.color.yellow))
            snack.show()
        }

        fun getMonth(month:Int):String?{
            var str = ""
            when(month){
                1 -> str = "January"
                2 -> str = "Febuary"
                3 -> str = "March"
                4 -> str = "April"
                5 -> str = "May"
                6 -> str = "June"
                7 -> str = "July"
                8 -> str = "August"
                9 -> str = "September"
                10 -> str = "October"
                11 -> str = "November"
                12 -> str = "December"
            }
            return str
        }

        fun hideKeyboard(activity: Activity) {
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view: View? = activity.currentFocus
            if (view == null)
                view = View(activity)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }

        fun base64toImage(base64:String):Bitmap{
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

    }
}
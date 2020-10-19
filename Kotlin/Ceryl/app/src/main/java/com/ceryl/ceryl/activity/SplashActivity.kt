package com.ceryl.ceryl.activity

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ceryl.ceryl.R
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.LocalRepositories
import com.ceryl.ceryl.util.Preferences
import java.util.*

class SplashActivity : AppCompatActivity() {
    private var delay : Long = 1500
    var appUser: AppUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        appUser = LocalRepositories.getAppUser(this)
        if (appUser == null) {
            appUser = AppUser()
            LocalRepositories.saveAppUser(this, appUser!!)
        }
        val currentapiVersion = Build.VERSION.SDK_INT
        if (currentapiVersion <= 22) {
            val runSplash = Timer()
            val showSplash: TimerTask = object : TimerTask() {
                override fun run() {
                    if (Preferences.isLogin) {
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
                        finish()
                    } else {
                        startActivity(Intent(applicationContext, LoginActivity::class.java))
                        finish()
                    }
                }
            }
            // Start the timer
            runSplash.schedule(showSplash, delay)
        } else {
            checkPermissions()
        }
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.INTERNET,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ), Cv.PERMISSIONS_BUZZ_REQUEST
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        when (requestCode) {
            Cv.PERMISSIONS_BUZZ_REQUEST -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val runSplash = Timer()
                val showSplash: TimerTask = object : TimerTask() {
                    override fun run() {
                        if (Preferences.isLogin) {
                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                            finish()
                        } else {
                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                            finish()
                        }
                    }
                }
                // Start the timer
                runSplash.schedule(showSplash, delay)
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Ceryl")
                    .setMessage("Please accept the permission for better use.")
                    .setPositiveButton("Ok",{dialog: DialogInterface?, which: Int ->
                        dialog!!.dismiss()
                    })
                    .show()
            }
        }
    }
}
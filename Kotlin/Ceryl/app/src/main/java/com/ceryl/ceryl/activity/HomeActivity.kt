package com.ceryl.ceryl.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.ceryl.ceryl.R
import com.ceryl.ceryl.adapter.HomeAdapter
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.network.ApiCallService
import com.ceryl.ceryl.network.response.course.AllCourseResponse
import com.ceryl.ceryl.util.*
import kotlinx.android.synthetic.main.activity_home.*
import org.greenrobot.eventbus.Subscribe
import java.util.ArrayList

class HomeActivity : RegisterAbstractActivity() {

    var appUser = AppUser()
    var listCourse = ArrayList<String>()
    var listColor = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)
        tvNavUser.setText(Preferences.full_name)

        val gridLayoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        rvHome.layoutManager = gridLayoutManager


        nav.setOnClickListener {
            if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
                drawerlayout.closeDrawer(GravityCompat.START)
            } else {
                drawerlayout.openDrawer(GravityCompat.START)
            }
        }

        navProfile.setOnClickListener {
            startActivity(Intent(HomeActivity@this, ProfileActivity::class.java))
            drawerlayout.closeDrawers()
        }

        ivLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes"){ dialog: DialogInterface?, which: Int ->
                    Preferences.email = ""
                    Preferences.full_name = ""
                    Preferences.isLogin = false
                    val intent = Intent(HomeActivity@this,LoginActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("No") { dialog: DialogInterface?, which: Int ->
                    dialog!!.dismiss()
                }
                .show()
        }
        apiAllCourse()
    }

    fun apiAllCourse(){
        if(ConnectivityReceiver().isConnected()){
            rotateloading.start()
            ApiCallService.action(HomeActivity@this,Cv.ACTION_GET_ALL_COURSE)
        }else{
            Helper.snackbar_alert(HomeActivity@this,getString(R.string.no_internet_connection),rlHomePage)
        }
    }

    @Subscribe
    fun get_course(response: AllCourseResponse){
        if(rotateloading.isStart)
            rotateloading.stop()
        if(response.status == 200){
            listColor.clear()
            listCourse.clear()
            for(i in 0..response.courses.size-1){
                listCourse.add(response.courses.get(i).course_name)
                listColor.add(response.courses.get(i).color)
            }
            rvHome.adapter = HomeAdapter(this,listCourse,listColor){COURSE:String,position:Int ->
                val intent = Intent(HomeActivity@this,CourseSummaryActivity::class.java)
                intent.putExtra("Course",COURSE)
                startActivity(intent)
            }
        }else{
            Helper.snackbar_alert(HomeActivity@this,response.message,rlHomePage)
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to Exit?")
            .setPositiveButton("Yes") {dialog: DialogInterface?, which: Int ->
                super.onBackPressed()
            }
            .setNegativeButton("No"){dialog: DialogInterface?, which: Int ->
                dialog!!.dismiss()
            }
            .show()
    }

    override fun layoutId(): Int {
        return R.layout.activity_home
    }
    @Subscribe
    fun timeout(msg: String) {
        if(rotateloading.isStart)
            rotateloading.stop()
        Helper.snackbar_alert(LoginActivity@this, Cv.TIMEOUT,rlHomePage)
    }
}
package com.ceryl.ceryl.activity

import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.ceryl.ceryl.R
import com.ceryl.ceryl.adapter.CourseExpandableListAdapter
import com.ceryl.ceryl.adapter.ExpandableListData
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Helper
import com.ceryl.ceryl.util.LocalRepositories
import kotlinx.android.synthetic.main.activity_course_content.*
import kotlinx.android.synthetic.main.activity_course_summary.*
import org.greenrobot.eventbus.Subscribe
import java.util.ArrayList

class CourseSummaryActivity : RegisterAbstractActivity(){

    var appUser = AppUser()
    var expandableListDetail: HashMap<String, List<String>>? = null
    var courseExpandableListAdapter : ExpandableListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this, appUser)
        tvCourseName.text = intent.extras!!.get("CourseName").toString()

        nav.setOnClickListener {
            if (drawerlayout.isDrawerOpen(GravityCompat.START))
                drawerlayout.closeDrawer(GravityCompat.START)
            else
                drawerlayout.openDrawer(GravityCompat.START)
        }

        expandableListDetail = ExpandableListData.getData()
        val expandableListTitle = ArrayList(expandableListDetail!!.keys)
        courseExpandableListAdapter = CourseExpandableListAdapter(this,expandableListTitle,expandableListDetail!!)
        evContent!!.setAdapter(courseExpandableListAdapter)
        for(i in 0..courseExpandableListAdapter!!.groupCount-1)
            evContent.expandGroup(i)

        evContent!!.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(applicationContext, "Group", Toast.LENGTH_SHORT).show()
        }

        evContent!!.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(applicationContext, " List Collapsed", Toast.LENGTH_SHORT).show()
        }

        evContent!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(applicationContext, "Clicked: ", Toast.LENGTH_SHORT).show()
            false
        }

        apiGetCourseContent()

    }

    fun apiGetCourseContent(){
        if(ConnectivityReceiver().isConnected()){
            appUser!!.course_content["course"] = intent.extras!!.get("CourseName").toString()
        }else{
            Helper.snackbar_alert(CourseSummaryActivity@ this,getString(R.string.no_internet_connection), rlCourseSummary)
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_course_summary
    }

    @Subscribe
    fun timeout(msg: String) {
        Helper.snackbar_alert(CourseSummaryActivity@ this, Cv.TIMEOUT, rlCourseSummary)
    }
}
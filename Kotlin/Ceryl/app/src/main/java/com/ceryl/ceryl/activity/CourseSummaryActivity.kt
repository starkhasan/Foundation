package com.ceryl.ceryl.activity

import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceryl.ceryl.R
import com.ceryl.ceryl.adapter.CourseExpandableListAdapter
import com.ceryl.ceryl.adapter.CourseSummaryAdapter
import com.ceryl.ceryl.adapter.ExpandableListData
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.network.ApiCallService
import com.ceryl.ceryl.network.response.course_content.Content
import com.ceryl.ceryl.network.response.course_content.CourseContentResponse
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Helper
import com.ceryl.ceryl.util.LocalRepositories
import kotlinx.android.synthetic.main.activity_course_summary.*
import kotlinx.android.synthetic.main.activity_course_summary.view.*
import org.greenrobot.eventbus.Subscribe
import java.util.*


class CourseSummaryActivity : RegisterAbstractActivity(){

    var appUser = AppUser()
    var expandableListDetail: HashMap<String, List<String>>? = null
    var courseExpandableListAdapter : ExpandableListAdapter?=null
    var title = ""
    var listContent = ArrayList<Content>()
    var courseSummaryAdapter : CourseSummaryAdapter ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this, appUser)
        tvCourseName.text = intent.extras!!.get("CourseName").toString()
        title = "About Java"

        nav.setOnClickListener {
            if (drawerlayout.isDrawerOpen(GravityCompat.START))
                drawerlayout.closeDrawer(GravityCompat.START)
            else
                drawerlayout.openDrawer(GravityCompat.START)
        }

        expandableListDetail = ExpandableListData.getData()
        val expandableListTitle = ArrayList(expandableListDetail!!.keys)
        courseExpandableListAdapter = CourseExpandableListAdapter(this, expandableListTitle, expandableListDetail!!)
        evContent!!.setAdapter(courseExpandableListAdapter)
        for(i in 0..courseExpandableListAdapter!!.groupCount-1)
            evContent.expandGroup(i)

        /*evContent!!.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(applicationContext, "Group", Toast.LENGTH_SHORT).show()
        }*/

        /*evContent!!.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(applicationContext, " List Collapsed", Toast.LENGTH_SHORT).show()
        }*/

        evContent!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            title = parent.expandableListAdapter.getChild(groupPosition, childPosition).toString()
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
            false
        }

        apiGetCourseContent()

    }

    fun apiGetCourseContent(){
        if(ConnectivityReceiver().isConnected()){
            rotateloading.start()
            appUser!!.course_content["course"] = intent.extras!!.get("CourseName").toString()
            appUser!!.course_content["title"] = title
            LocalRepositories.saveAppUser(this, appUser)
            ApiCallService.action(CourseSummaryActivity@ this, Cv.ACTION_COURSE_CONTENT)
        }else{
            Helper.snackbar_alert(CourseSummaryActivity@ this, getString(R.string.no_internet_connection), rlCourseSummary)
        }
    }


    @Subscribe
    fun course_content(response: CourseContentResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.status == 200){
            Toast.makeText(CourseSummaryActivity@this,response.message,Toast.LENGTH_SHORT).show()
            toolbar.tvHeading.text = response.title
            listContent.clear()
            for(i in 0..response.content.size-1){
                if(response.content[i].content !=""){
                    listContent.add(response.content[i])
                }
            }
            val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            rvContent.layoutManager = linearLayoutManager
            courseSummaryAdapter = CourseSummaryAdapter(this,listContent){COURSE:String,position:Int ->

            }
            rvContent.adapter = courseSummaryAdapter
        }else{
            Helper.snackbar_alert(CourseSummaryActivity@ this, response.message, rlCourseSummary)
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
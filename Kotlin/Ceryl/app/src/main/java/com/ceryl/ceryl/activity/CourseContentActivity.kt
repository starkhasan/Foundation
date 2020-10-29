package com.ceryl.ceryl.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceryl.ceryl.R
import com.ceryl.ceryl.adapter.CourseContentAdapter
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Helper
import com.ceryl.ceryl.util.LocalRepositories
import kotlinx.android.synthetic.main.activity_course_content.*
import kotlinx.android.synthetic.main.layout_custom_toolbar.*
import kotlinx.android.synthetic.main.layout_custom_toolbar.view.*
import org.greenrobot.eventbus.Subscribe

class CourseContentActivity : RegisterAbstractActivity(), View.OnClickListener{

    var appUser = AppUser()
    var courseList = ArrayList<String>()
    var courseContentList = ArrayList<String>()
    var courseName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)
        courseName = intent.extras!!.get("Course").toString()
        setToolBar()
        getCourseDetails()
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvCourseContent.layoutManager = linearLayoutManager
        rvCourseContent.adapter = CourseContentAdapter(this,courseList,courseContentList)

        rlStart.setOnClickListener {
            val intent = Intent(this,CourseSummaryActivity::class.java)
            intent.putExtra("CourseName",courseName)
            startActivity(intent)
        }

    }

    fun getCourseDetails(){
        val course = HomeActivity.courseContent.split("/")
        for(i in 0..course.size-1){
            val temp = course[i].split("(")
            courseList.add(temp[0])
            courseContentList.add(temp[1].substring(0,temp[1].length-1))
        }
    }

    fun setToolBar(){
        val name = courseName
        toolBar.tvHeading.setText(name.toString())
        toolBar.ivBack.setOnClickListener(this)

    }
    override fun layoutId(): Int {
        return R.layout.activity_course_content
    }
    @Subscribe
    fun timeout(msg: String) {
        Helper.snackbar_alert(LoginActivity@this, Cv.TIMEOUT,rlCourseSummary)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            ivBack.id -> finish()
        }
    }
}
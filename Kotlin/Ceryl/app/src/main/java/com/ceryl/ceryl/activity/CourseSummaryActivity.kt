package com.ceryl.ceryl.activity

import android.os.Bundle
import android.view.View
import com.ceryl.ceryl.R
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.util.AppUser
import com.ceryl.ceryl.util.Cv
import com.ceryl.ceryl.util.Helper
import com.ceryl.ceryl.util.LocalRepositories
import kotlinx.android.synthetic.main.activity_course_summary.*
import kotlinx.android.synthetic.main.layout_custom_toolbar.*
import kotlinx.android.synthetic.main.layout_custom_toolbar.view.*
import org.greenrobot.eventbus.Subscribe

class CourseSummaryActivity : RegisterAbstractActivity(), View.OnClickListener{

    var appUser = AppUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)
        setToolBar()

    }

    fun setToolBar(){
        val name = intent.extras!!.get("Course")
        toolBar.tvHeading.setText(name.toString())
        toolBar.ivBack.setOnClickListener(this)

    }
    override fun layoutId(): Int {
        return R.layout.activity_course_summary
    }
    @Subscribe
    fun timeout(msg: String) {
        if (rotateloading.isStart)
            rotateloading.stop()
        Helper.snackbar_alert(LoginActivity@this, Cv.TIMEOUT,rlCourseSummary)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            ivBack.id -> finish()
        }
    }
}
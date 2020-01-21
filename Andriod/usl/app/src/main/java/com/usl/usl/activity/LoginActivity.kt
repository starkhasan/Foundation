package com.usl.usl.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.usl.usl.R

class LoginActivity : AppCompatActivity() ,View.OnClickListener{

    @BindView(R.id.toolbar)
    lateinit var toolbar: View
    lateinit var tvHeading: TextView
    lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        settoolbar()
    }

    private fun settoolbar(){
        tvHeading=toolbar.findViewById(R.id.tvHeading)
        tvHeading.setText("Login")
        ivBack=toolbar.findViewById(R.id.ivBack)
        ivBack.visibility=View.GONE
    }

    override fun onClick(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
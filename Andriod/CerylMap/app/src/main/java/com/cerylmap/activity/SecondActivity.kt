package com.cerylmap.activity

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cerylmap.R
import kotlinx.android.synthetic.main.activit_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activit_second)


        btnDialog.setOnClickListener {
            var dialog:Dialog?=null
            dialog !!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog .setCancelable(false)
            dialog .setContentView(R.layout.custom_layout)
            val body = dialog .findViewById(R.id.tvTitle) as TextView
            body.text = "Title of the Dialog"
            val yesButton = dialog .findViewById(R.id.btnDialogClick) as Button
            yesButton.setOnClickListener {
                dialog .dismiss()
            }

        }

    }


}
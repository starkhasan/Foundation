package com.ceryl.ceryl.activity

import android.R.attr.data
import android.app.Dialog
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ceryl.ceryl.R
import com.suke.widget.SwitchButton
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.row_bottompopup.*
import kotlinx.android.synthetic.main.row_customdialog.*


class ThirdActivity : AppCompatActivity() , SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var myProximitySensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        ivEdit.setOnClickListener {view: View ->
            var dialog = Dialog(this@ThirdActivity)
            dialog.setContentView(R.layout.row_customdialog)
            dialog.setCanceledOnTouchOutside(true)

            dialog.tvYES.setOnClickListener {
                if(dialog.etOTP.text.toString()!=""){
                    Toast.makeText(applicationContext,"Your OTP "+dialog.etOTP.text.toString(),Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
               }else{
                    Toast.makeText(applicationContext,"Please Enter OTP",Toast.LENGTH_SHORT).show()
                }
            }
            dialog.tvNO.setOnClickListener {
                Toast.makeText(applicationContext,"NO",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.show()
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        }

        ivDelete.setOnClickListener {
            var dialog =  Dialog(this@ThirdActivity)
            dialog.setContentView(R.layout.row_bottompopup)
            dialog.setCanceledOnTouchOutside(true)

            dialog.ivCancel.setOnClickListener {
                dialog.dismiss()
            }

            dialog.llGood.setOnClickListener {
                dialog.cbGood.isChecked=true
                dialog.cbBad.isChecked=false
                dialog.cbMedium.isChecked=false
            }
            dialog.llBad.setOnClickListener {
                dialog.cbGood.isChecked=false
                dialog.cbBad.isChecked=true
                dialog.cbMedium.isChecked=false
            }
            dialog.llMedium.setOnClickListener {
                dialog.cbGood.isChecked=false
                dialog.cbBad.isChecked=false
                dialog.cbMedium.isChecked=true
            }

            dialog.btnSubmit.setOnClickListener {
                if(dialog.cbGood.isChecked && dialog.ratingbar.rating!=0f){
                    Toast.makeText(applicationContext,"You Select "+dialog.cbGood.text.toString()+" With Rating "+dialog.ratingbar.rating.toString(),Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                if(dialog.cbBad.isChecked && dialog.ratingbar.rating!=0f){
                    Toast.makeText(applicationContext,"You Select "+dialog.cbBad.text.toString()+" With Rating "+dialog.ratingbar.rating.toString(),Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                if(dialog.cbMedium.isChecked && dialog.ratingbar.rating!=0f){
                    Toast.makeText(applicationContext,"You Select "+dialog.cbMedium.text.toString()+" With Rating "+dialog.ratingbar.rating.toString(),Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }

            val layoutparam = dialog.window!!.attributes
            layoutparam.gravity = Gravity.BOTTOM
            dialog.show()
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        }


        switch_button.setOnCheckedChangeListener(object:SwitchButton.OnCheckedChangeListener{//Custom Toogle Button
            override fun onCheckedChanged(view: SwitchButton?, isChecked: Boolean) {
                when {
                    isChecked -> Toast.makeText(applicationContext,"ON",Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(applicationContext,"OFF",Toast.LENGTH_SHORT).show()
                }
            }
        })

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        myProximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        if(myProximitySensor==null){
            Toast.makeText(applicationContext,"No Proximity Sensor Available",Toast.LENGTH_SHORT).show()
        }else{
           Toast.makeText(applicationContext,"Proximity Sensore Available",Toast.LENGTH_SHORT).show()
        }


        ivAdd.setOnClickListener {
            var inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflater.inflate(R.layout.layout_new,null);
            rlParentLayout.addView(view,rlParentLayout.childCount-1)
        }

        ivRemove.setOnClickListener { view ->
            rlParentLayout.removeView(view.parent as View)
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] == 0.0F && event.values[0]!=null) {
                tvProximitySensor.text=("Near")
            } else {
                tvProximitySensor.text=("Away")
            }
        }
    }


    override fun onResume() {
        super.onResume()
        myProximitySensor?.also { light ->
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}
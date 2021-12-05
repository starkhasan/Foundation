package com.ali.sampleandroid.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.ActivityMainBinding

class FirstActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(activityMainBinding.root)
        Log.v("First Activity","ON_CREATED")
        activityMainBinding.btnSubmit.setOnClickListener(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val data = intent!!.extras
        supportActionBar?.setTitle(data!!.get("Activity_Name").toString())
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            Log.v("Result",intent.toString())
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit -> {
                if(validation()){
                    val bundle = Bundle()
                    bundle.putString("Name",activityMainBinding.etName.text.toString())
                    bundle.putString("Email",activityMainBinding.etEmail.text.toString())
                    val intent = Intent(this,SecondActivity::class.java)
                    intent.putExtras(bundle)
                    startForResult.launch(intent)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun validation(): Boolean {
        if(activityMainBinding.etEmail.text.isBlank()) {
            Toast.makeText(this, "Please provide name", Toast.LENGTH_SHORT).show()
            return false
        }else if(activityMainBinding.etEmail.text.isBlank()){
            Toast.makeText(this,"Please provide email", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.v("First Activity","ON_START")
    }

    override fun onResume() {
        super.onResume()
        Log.v("First Activity","ON_RESUME")
    }

    override fun onPause() {
        super.onPause()
        Log.v("First Activity","ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.v("First Activity","ON_STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("First Activity","ON_DESTROY")
    }

}
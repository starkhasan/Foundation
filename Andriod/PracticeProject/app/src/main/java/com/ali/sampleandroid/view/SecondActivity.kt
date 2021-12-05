package com.ali.sampleandroid.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ali.sampleandroid.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var activitySecondActivity: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySecondActivity = ActivitySecondBinding.inflate(LayoutInflater.from(this))
        setContentView(activitySecondActivity.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        if (bundle != null) {
            activitySecondActivity.tvBundleData.text = bundle.getString("Name").plus(bundle.getString("Email"))
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("DATA_SECOND", "Hi Ali")
        setResult(Activity.RESULT_OK, intent)
        finish()
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent()
                intent.putExtra("DATA_SECOND", "Hi Ali")
                setResult(Activity.RESULT_OK, intent)
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
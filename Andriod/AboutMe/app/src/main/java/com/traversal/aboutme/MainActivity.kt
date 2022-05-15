package com.traversal.aboutme
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.traversal.aboutme.activity.FileActivity
import com.traversal.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityMainBinding
    //creating the instance of the data and set the name
    private val myNameModel: NameModel = NameModel("Ali Hasan","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        //set value of my name variable
        setContentView(binding.root)
        binding.myName = myNameModel
        binding.addNickName.setOnClickListener {
            //addNickName()
            startActivity(Intent(this, FileActivity::class.java))
        }
    }

    private fun addNickName(){
        binding.apply {
            myName?.nickName = "nameEditText.text.toString()"
            addNickName.visibility = View.GONE
            nameEditText.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}
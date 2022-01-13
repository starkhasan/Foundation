package com.traversal.notestodo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.traversal.notestodo.R
import com.traversal.notestodo.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setToolbar()
    }

    private fun setToolbar(){
        binding.layoutHeader.tvHeader.text = resources.getString(R.string.back_up_notes)
        binding.layoutHeader.ivDelete.visibility = View.GONE
        binding.layoutHeader.ivNavBar.setImageResource(R.drawable.icon_arrow)
        binding.layoutHeader.ivNavBar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.ivNavBar -> {
                finish()
            }
        }
    }
}
package com.traversal.devicestorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.traversal.devicestorage.databinding.ActivityMainBinding
import java.io.File
import android.system.Os.stat




class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.btnStorage.setOnClickListener(this)
    }

    private fun deviceStorage() {
        if(isExternalMemoryAvailable()){
            val size = totalExternalMemorySize()
            Toast.makeText(this,size,Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"External Memory Not Available",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
           R.id.btnStorage -> {
               deviceStorage()
           }
           else -> {
               Toast.makeText(this,"Click Appropriate Button",Toast.LENGTH_SHORT).show()
           }
        }
    }

    private fun totalExternalMemorySize() : String {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val availableBlocks = stat.availableBlocksLong
        return (availableBlocks * blockSize).toString()
    }

    private fun isExternalMemoryAvailable() : Boolean {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)
    }
}
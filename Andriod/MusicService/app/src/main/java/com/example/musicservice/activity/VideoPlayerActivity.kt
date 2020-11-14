package com.example.musicservice.activity

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicservice.R
import com.example.musicservice.adapter.VideoAdapter
import com.example.musicservice.response.VideoModel
import kotlinx.android.synthetic.main.activity_videoplayer.*

class VideoPlayerActivity : AppCompatActivity() {

    val PERMISSION_CODE = 1
    val linearLayoutManager: LinearLayoutManager ?= null
    var videoAdapter:VideoAdapter? = null
    var videoList = ArrayList<VideoModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplayer)

        ivMusic.setOnClickListener {
            finish()
        }

        /*btnPlay.setOnClickListener {
            startActivity(Intent(this,VideoPlayer::class.java))
        }*/

        checkPermision()
    }

    fun checkPermision(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            getVideoFile()
        }else{
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),PERMISSION_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_CODE -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.size > 0)
                    getVideoFile()
                else
                    Toast.makeText(this,"Please rant permission for better result",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getVideoFile(){
        val cr = getContentResolver()
        val uri: Uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val cursor = applicationContext.contentResolver.query(uri, null, null, null, null)
        videoList.clear()

        val idColumn: Int = cursor!!.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
        val nameColumn: Int = cursor!!.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)
        val durationColumn: Int = cursor!!.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)
        val sizeColumn: Int = cursor!!.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE)
        val volume : Int = cursor!!.getColumnIndexOrThrow(MediaStore.Video.Media.VOLUME_NAME)

        while (cursor!!.moveToNext()){
            val id = cursor.getLong(idColumn)
            val title = cursor.getString(nameColumn)
            val duration = cursor.getInt(durationColumn)
            val size = cursor.getInt(sizeColumn)
            val url: Uri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id)
            val fullPath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))
            val modelAudio = VideoModel(title, url.toString(), duration.toString(), size,fullPath,false)
            videoList.add(modelAudio)
        }
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvVideo.layoutManager = linearLayoutManager
        videoAdapter = VideoAdapter(this,videoList){position:Int,uri:String,flag:String ->
            if(flag == "Play"){
                val intent = Intent(this,VideoPlayer::class.java)
                intent.putExtra("url",videoList[position].uri)
                startActivity(intent)
            }
        }
        rvVideo.adapter = videoAdapter
    }

}
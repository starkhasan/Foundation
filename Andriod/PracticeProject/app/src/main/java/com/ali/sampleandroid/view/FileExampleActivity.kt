package com.ali.sampleandroid.view

import android.content.ContentUris
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.ali.sampleandroid.adapter.ImageFileAdapter
import com.ali.sampleandroid.adapter.VideoFileAdapter
import com.ali.sampleandroid.databinding.ActivityFilesBinding
import com.ali.sampleandroid.model.ImageModel
import com.ali.sampleandroid.model.VideoModel
import com.ali.sampleandroid.utils.HelperUtils
import android.os.Parcelable

class FileExampleActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 1
    private lateinit var fileLayout: ActivityFilesBinding
    private lateinit var videoFileAdapter: VideoFileAdapter
    private lateinit var imageFileAdapter: ImageFileAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private val listVideos = mutableListOf<VideoModel>()
    private val listImages = mutableListOf<ImageModel>()
    private var state: Parcelable?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fileLayout = ActivityFilesBinding.inflate(LayoutInflater.from(this))
        setContentView(fileLayout.root)
        gridLayoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        fileLayout.rvVideos.layoutManager = gridLayoutManager
    }

    override fun onResume() {
        super.onResume()
        filePermission()
    }

    override fun onPause() {
        super.onPause()
        state = gridLayoutManager.onSaveInstanceState()!!
    }

    private fun filePermission(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            //loadFileForImage()
            loadFile()
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //loadFileForImage()
                    loadFile()
                } else {
                    HelperUtils.showToast(this, "Request Permission Failed")
                }
            }
            else -> {
                HelperUtils.showToast(this, "Please Allow permission for better result")
            }
        }
    }

    private fun loadFile(){
        val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val cursor = applicationContext.contentResolver.query(uri, null, null, null, null, null)
        listVideos.clear()
        while (cursor!!.moveToNext()){
            val name = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME))
            val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
            val size = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.SIZE))
            val url: Uri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id)
            listVideos.add(VideoModel(url.toString(), name, size))
        }
        videoFileAdapter = VideoFileAdapter(this, listVideos){ position: Int ->
            val intent = Intent(this,VideoPlayActivity::class.java)
            intent.putExtra("VideoURI",listVideos[position].url)
            startActivity(intent)
        }
        fileLayout.rvVideos.adapter = videoFileAdapter
    }

    private fun loadFileForImage(){
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor = applicationContext.contentResolver.query(uri, null, null, null, null, null)
        listImages.clear()
        while(cursor!!.moveToNext()){
            val size = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media.SIZE))
            val name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
            val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
            val uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
            listImages.add(ImageModel(name, size, uri.toString()))
        }
        imageFileAdapter = ImageFileAdapter(this, listImages){ position: Int ->
            val intent = Intent(this, ImageViewActivity::class.java)
            intent.putExtra("ImageURI", listImages[position].url)
            startActivity(intent)
        }
        fileLayout.rvVideos.adapter = imageFileAdapter
        if(state != null){
            gridLayoutManager.onRestoreInstanceState(state)
        }
    }
}
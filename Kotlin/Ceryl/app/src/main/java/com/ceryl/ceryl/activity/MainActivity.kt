package com.ceryl.ceryl.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.provider.MediaStore
import android.provider.MediaStore.Images
import android.view.View
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.ceryl.ceryl.R
import com.ceryl.ceryl.adapter.MusicAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() ,View.OnClickListener{

    var toggle:ActionBarDrawerToggle?=null
    @BindView(R.id.drawerlayout)
    lateinit var drawerlayout:DrawerLayout
    @BindView(R.id.nav)
    lateinit var nav:ImageView
    @BindView(R.id.fab)
    lateinit var fab:FloatingActionButton
    var arrayList = ArrayList<String>()
    var arrayListImage = ArrayList<String>()
    var imageArray = ArrayList<Bitmap>()
    lateinit var linearLayoutManager: LinearLayoutManager
    @BindView(R.id.rvMusic)
    lateinit var rvData:RecyclerView
    @BindView(R.id.pbLoadMusic)
    lateinit var progressBar:ProgressBar
    lateinit var musicAdapter: MusicAdapter

    var scrolling = true
    var currentItem:Int?=null
    var totalItem:Int?=null
    var scrolledOutItem:Int?=null
    var i:Int = 0

    private val requestCode = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        toggle = ActionBarDrawerToggle(this,drawerlayout,
            R.string.Open,
            R.string.Close
        )
        drawerlayout.addDrawerListener(toggle!!)
        toggle!!.syncState()

        linearLayoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        rvData.layoutManager=linearLayoutManager
        fab.setOnClickListener(this)
        nav.setOnClickListener(this)
    }

    fun list(view: View?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), requestCode)
        } else {
            listExternalStorage()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == this.requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                listExternalStorage()
            } else {
                Toast.makeText(this, "Until you grant the permission, I cannot list the files", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("NewApi")
    private fun listExternalStorage() {
        val state = Environment.getExternalStorageState()

        if (Environment.MEDIA_MOUNTED == state || Environment.MEDIA_MOUNTED_READ_ONLY == state) {
            // Container for information about each video.
            data class Video(val uri: Uri, val name: String, val duration: Int, val size: Int)
            val videoList = mutableListOf<Video>()
            val projection = arrayOf(Images.Media._ID, MediaStore.Video.Media.DISPLAY_NAME, Images.Media.DURATION, Images.Media.SIZE)
            // Show only videos that are at least 5 minutes in duration.
            val selection = "${MediaStore.Video.Media.DURATION} >= ?"
            val selectionArgs = arrayOf(TimeUnit.MILLISECONDS.convert(10, TimeUnit.MINUTES).toString())
            // Display videos in alphabetical order based on their display name.
            val sortOrder = "${MediaStore.Video.Media.DISPLAY_NAME} ASC"

            var query = applicationContext.contentResolver.query(Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
            query?.use { cursor ->
                // Cache column indices.
                val idColumn = cursor.getColumnIndexOrThrow(Images.Media._ID)
                val nameColumn = cursor.getColumnIndexOrThrow(Images.Media.DISPLAY_NAME)
                val sizeColumn = cursor.getColumnIndexOrThrow(Images.Media.SIZE)
                //val volumeName = cursor.getColumnName(cursor.getColumnIndexOrThrow(Images.Media.VOLUME_NAME))

                while (cursor.moveToNext()) {
                    // Get values of columns for a given video.
                    val id = cursor.getLong(idColumn)
                    val name = cursor.getString(nameColumn)
                    arrayList.add(name.toString())
                    //val thumbnail: Bitmap = applicationContext.contentResolver.loadThumbnail(getContentUri (volumeName), Size(640, 480), null)
                    //imageArray.add(thumbnail)
                }
            }
            for(i in 0..50){
                arrayListImage.add(arrayList.get(i))
            }

            musicAdapter= MusicAdapter(this,arrayListImage)
            rvData.adapter=musicAdapter

            rvData.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    currentItem = linearLayoutManager.getChildCount();
                    totalItem = linearLayoutManager.getItemCount();
                    scrolledOutItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition();

                    if(dy > 0){
                        if(scrolling && (scrolledOutItem!! + currentItem!! == totalItem!!))
                        {
                            scrolling=false;
                            fetchdata();
                        }
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    {
                        scrolling=true;
                    }
                }
            })
        }
    }

    fun fetchdata(){
        progressBar.visibility=View.VISIBLE
        Handler().postDelayed(Runnable {
            i = i + scrolledOutItem!!
            var j = 1
            var posImage:Int = i!!
            while (j <=50){
                arrayListImage.add(arrayList[posImage!!])
                if(posImage <= arrayList.size){
                    posImage++
                }
                j++
            }
            musicAdapter.notifyDataSetChanged()
            progressBar.visibility = View.GONE
        },200)
    }



    override fun onClick(view: View?) {
        when(view?.id){
            R.id.nav -> {
                if(drawerlayout.isDrawerOpen(GravityCompat.START)){
                    drawerlayout.closeDrawer(GravityCompat.START)
                }else{
                    drawerlayout.openDrawer(GravityCompat.START)
                }
            }
            R.id.fab -> {
                val intent=Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
            else -> {
            }
        }
    }

}





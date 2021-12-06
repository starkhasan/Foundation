package com.ali.sampleandroid.view
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.sampleandroid.R
import com.ali.sampleandroid.adapter.HomeAdapter
import com.ali.sampleandroid.databinding.ActivityHomeBinding
import com.ali.sampleandroid.view.bottom_navigation.BottomNavigationActivity
import com.ali.sampleandroid.view.broadcast_example.BroadcastActivity
import com.ali.sampleandroid.view.realtime_tracking.HomeScreenActivity

class HomeActivity : AppCompatActivity() {

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var homeAdapter: HomeAdapter
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val listScreen = listOf(
        "LifeCycle",
        "Bundle",
        "Tab",
        "Capture Image",
        "View Pager",
        "Dynamic Content",
        "Realtime Tracking",
        "Bottom Navigation Bar",
        "Boradcast Receiver",
        "HTTP Operation"
    )
    private lateinit var activityHomeBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(activityHomeBinding.root)
        supportActionBar?.setTitle("Home")

        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.navOpen,R.string.navClose)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        activityHomeBinding.rvHome.layoutManager = linearLayoutManager
        homeAdapter = HomeAdapter(listScreen){ position: Int ->
            //switch case in kotlin
            when(position){
                //multiple case
                0, 1 -> {
                    val intent = Intent(this,FirstActivity::class.java)
                    if(position == 0)
                        intent.putExtra("Activity_Name","LifeCycle")
                    else
                        intent.putExtra("Activity_Name","Bundle")
                    startActivity(intent)
                }
                //single case
                2 -> startActivity(Intent(this,TabLayoutActivity::class.java))
                3 -> startActivity(Intent(this, ImageCaptureActivity::class.java))
                4 -> startActivity(Intent(this, ViewPageActivity::class.java))
                5 -> startActivity(Intent(this, DynamicAddRemove::class.java))
                6 -> {
                    startActivity(Intent(this, HomeScreenActivity::class.java))
//                    val intent = Intent(this,GoogleMapActivity::class.java)
//                    intent.putExtra("userAddress","979234")
//                    intent.putExtra("remoteAddress","979019")
//                    startActivity(intent)
                }
                7 -> startActivity(Intent(this,BottomNavigationActivity::class.java))
                8 -> startActivity(Intent(this,BroadcastActivity::class.java))
            }
        }
        activityHomeBinding.rvHome.adapter = homeAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                if(drawerLayout.isDrawerOpen(item.itemId)){
                    drawerLayout.closeDrawer(GravityCompat.END)
                }else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .setPositiveButton("Yes"){_, _ -> super.onBackPressed()}
            .show()
    }
}
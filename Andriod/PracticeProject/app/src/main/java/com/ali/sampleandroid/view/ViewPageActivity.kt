package com.ali.sampleandroid.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.sampleandroid.R
import com.ali.sampleandroid.adapter.HighlightAdapter
import com.ali.sampleandroid.adapter.ViewpagerAdapter
import com.ali.sampleandroid.databinding.ActivityViewpageBinding

class ViewPageActivity : AppCompatActivity() {

    lateinit var viewpagerAdapter: ViewpagerAdapter
    lateinit var highlightAdapter: HighlightAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var favBool : Boolean = false
    var listImages = listOf(
        R.drawable.first,
        R.drawable.second,
        R.drawable.third,
        R.drawable.forth,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten,
        R.drawable.eleven,
        R.drawable.twelve,
        R.drawable.thirteen,
        R.drawable.fourteen,
        R.drawable.fifteen,
    )

    var mapImage  = mapOf(
            R.drawable.first to false,
            R.drawable.second to false,
            R.drawable.third to false,
            R.drawable.forth to false,
            R.drawable.five to false,
            R.drawable.six to false,
            R.drawable.seven to false,
            R.drawable.eight to false,
            R.drawable.nine to false,
            R.drawable.ten to false,
            R.drawable.eleven to false,
            R.drawable.twelve to false,
            R.drawable.thirteen to false,
            R.drawable.fourteen to false,
            R.drawable.fifteen to false
    )
    val listHighlight = listOf(
            "Screen Resolution Type:Full HD",
            "Brightness: 300 Nits",
            "Response Time: 5ms",
            "Refresh Rate: 75Hz",
            "HDMI Ports - 2"
    )

    private lateinit var activityViewPageActivity: ActivityViewpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityViewPageActivity = ActivityViewpageBinding.inflate(layoutInflater)
        setContentView(activityViewPageActivity.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("ViewPager")

        //make nestedScrolling false to RecyclerView and setting up layout manager
        activityViewPageActivity.rvHighlight.isNestedScrollingEnabled = false
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        activityViewPageActivity.rvHighlight.layoutManager = linearLayoutManager
        //setting adapter to viewpager
        viewpagerAdapter = ViewpagerAdapter(listImages){ position: Int ->
            Toast.makeText(this,"User Click on $position Image",Toast.LENGTH_SHORT).show()
        }
        activityViewPageActivity.vpMain.adapter = viewpagerAdapter
        activityViewPageActivity.vpCircleIndicator.setViewPager(activityViewPageActivity.vpMain)
        /*
        *ViewPager PageChange Listener
        activityViewPageActivity.vpMain.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int,positionOffset: Float,positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
                TODO("Not yet implemented")
            }
            override fun onPageScrollStateChanged(state: Int) {
                TODO("Not yet implemented")
            }
        })*/

        //setting adapter to recycler view
        highlightAdapter = HighlightAdapter(listHighlight)
        activityViewPageActivity.rvHighlight.adapter = highlightAdapter

        activityViewPageActivity.rlAllDetails.setOnClickListener{
            Toast.makeText(this,"Click on All Details",Toast.LENGTH_SHORT).show()
        }

        //Onclick of fav icon change the color of the heart Symbol and also show toast this image number added to favorite product list
        activityViewPageActivity.rlFavItem.setOnClickListener {
            if(favBool) {
                activityViewPageActivity.ivFavItem.setImageResource(R.drawable.icon_fav)
                favBool = false
            }else{
                activityViewPageActivity.ivFavItem.setImageResource(R.drawable.icon_fav_select)
                favBool = true
            }
        }

        activityViewPageActivity.rlCartAdd.setOnClickListener {
            Toast.makeText(this,"Add to Cart",Toast.LENGTH_SHORT).show()
        }

        activityViewPageActivity.rlBuyNow.setOnClickListener {
            Toast.makeText(this,"Buy Now Product",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
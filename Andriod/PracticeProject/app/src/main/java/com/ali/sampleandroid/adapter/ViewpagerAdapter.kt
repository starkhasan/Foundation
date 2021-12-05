package com.ali.sampleandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.ali.sampleandroid.databinding.RowPagerBinding

class ViewpagerAdapter(private val listImages: List<Int>,private val listener: (Int) -> Unit) : PagerAdapter() {

    //It returns the no of view available
    override fun getCount(): Int {
        return listImages.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        /*
        * Before view binding
        val imageLayout = LayoutInflater.from(container.context).inflate(R.layout.row_pager,container,false)
        val imageView = imageLayout.findViewById<ImageView>(R.id.ivPager)
        imageView.setImageResource(listImages[position])
        container.addView(imageLayout,0)
        return imageLayout*/

        //Using view binding
        val binding = RowPagerBinding.inflate(LayoutInflater.from(container.context),container,false)
        binding.ivPager.setImageResource(listImages[position])
        binding.ivPager.setOnClickListener {
            listener(position)
        }
        container.addView(binding.root,0)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}
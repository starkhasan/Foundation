package com.ali.demoapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.ali.demoapplication.databinding.MainLayoutBinding
import com.ali.demoapplication.model.Model
import com.ali.demoapplication.viewModel.AppViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayoutBinding: MainLayoutBinding = DataBindingUtil.setContentView(
            MainActivity@ this,
            R.layout.main_layout
        )
        var model = Model("alihasan@gmail.com", 3423)
        mainLayoutBinding.setViewModel(AppViewModel())
        mainLayoutBinding.executePendingBindings()
        mainLayoutBinding.lifecycleOwner = this
    }

    @BindingAdapter("toastMessage")
    fun runMe(view: View, message: String?) {
        if (message != null) Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show()
    }

}
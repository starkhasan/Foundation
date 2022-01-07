package com.traversal.notestodo.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.traversal.notestodo.databinding.ActivityNotesHomeBinding

class NotesHomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityNotesHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}
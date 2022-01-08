package com.traversal.notestodo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.traversal.notestodo.databinding.ActivityNotesHomeBinding

class NotesHomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityNotesHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        binding.fabAddNotes.setOnClickListener {
            binding.llNotes.visibility = View.VISIBLE
            binding.fabAddNotes.visibility = View.GONE
        }

        binding.root.viewTreeObserver.addOnGlobalLayoutListener {
            val heightDiff = binding.root.rootView.height - binding.root.height
            if (heightDiff < 100) {
                binding.llNotes.visibility = View.GONE
                binding.fabAddNotes.visibility = View.VISIBLE
            }
        }
    }

    //Showing Confirmation Dialog before the Exit of Application
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes"){ _, _ ->
                super.onBackPressed()
            }
            .setNegativeButton("No"){ dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
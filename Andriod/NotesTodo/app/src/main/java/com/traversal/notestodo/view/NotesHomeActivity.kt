package com.traversal.notestodo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.traversal.notestodo.databinding.ActivityNotesHomeBinding
import com.traversal.notestodo.view.adapter.CompleteTaskAdapter
import com.traversal.notestodo.view.adapter.TaskAdapter

class NotesHomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityNotesHomeBinding
    private val listTask = mutableListOf(
        "How Are you",
        "Brinjal",
        "Dahi (Curd)",
        "Haldi",
        "Mirchi",
        "Masala",
        "Namak",
        "Sabji",
        "Chicken"
    )

    private val listCompletedTask = mutableListOf(
        "Hello",
        "My Name is Ali Hasan",
        "Allu Tamater",
        "Atta",
        "Mustured Oil"
    )
    private lateinit var linearLayoutManagerTask: LinearLayoutManager
    private lateinit var linearLayoutManagerCompleteTask: LinearLayoutManager
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var completeTaskAdapter: CompleteTaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        linearLayoutManagerTask = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        linearLayoutManagerCompleteTask = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvTask.layoutManager = linearLayoutManagerTask
        binding.rvCompleted.layoutManager = linearLayoutManagerCompleteTask
        binding.rvTask.isNestedScrollingEnabled = false
        binding.rvCompleted.isNestedScrollingEnabled = false

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

        taskAdapter = TaskAdapter(listTask){ position: Int ->
            Toast.makeText(this,"You Clicked on $position",Toast.LENGTH_SHORT).show()
        }
        binding.rvTask.adapter = taskAdapter

        completeTaskAdapter = CompleteTaskAdapter(listCompletedTask){ position: Int ->
            Toast.makeText(this,"You Click $position",Toast.LENGTH_SHORT).show()
        }
        binding.rvCompleted.adapter = completeTaskAdapter
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
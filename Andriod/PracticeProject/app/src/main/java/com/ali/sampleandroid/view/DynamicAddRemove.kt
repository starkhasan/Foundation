package com.ali.sampleandroid.view

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.sampleandroid.adapter.DynamicAdapter
import com.ali.sampleandroid.databinding.ActivityDynamicBinding


class DynamicAddRemove : AppCompatActivity() {

    lateinit var activityDynamicBinding: ActivityDynamicBinding
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dynamicAdapter: DynamicAdapter

    //this is a Read-Only List
    val listTask = mutableListOf(
        "Completed",
        "Recent",
        "Ongoing",
        "Upcoming",
        "Finished",
        "Delayed",
        "Quick"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDynamicBinding = ActivityDynamicBinding.inflate(layoutInflater)
        setContentView(activityDynamicBinding.root)
        supportActionBar?.setTitle("Dynamic Content")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        activityDynamicBinding.rvDynamic.layoutManager = linearLayoutManager

        dynamicAdapter = DynamicAdapter(listTask){ position: Int ->
            deleteRecyclerData(position)
        }
        activityDynamicBinding.rvDynamic.adapter = dynamicAdapter


        activityDynamicBinding.fabAddTask.setOnClickListener {
            activityDynamicBinding.fabAddTask.visibility = View.GONE
            activityDynamicBinding.llAddTask.visibility = View.VISIBLE
        }

        activityDynamicBinding.etAddDynamicData.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE && !v?.text?.isBlank()!!) {
                    hideKeyboard(this@DynamicAddRemove)
                    Toast.makeText(applicationContext, "New Data Inserted", Toast.LENGTH_SHORT).show()
                    listTask.add(v.text.toString())
                    dynamicAdapter.notifyDataSetChanged()
                    activityDynamicBinding.fabAddTask.visibility = View.VISIBLE
                    activityDynamicBinding.llAddTask.visibility = View.GONE
                    activityDynamicBinding.etAddDynamicData.text.clear()
                }
                return true
            }
        })

        /*
        *EditText Change Listener in Android editText.addTextChangeListener(object: TextWatcher{})
        activityDynamicBinding.etAddDynamicData.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }
        })*/
    }

    fun deleteRecyclerData(position: Int){
        val item = listTask[position]
        listTask.remove(item)
        dynamicAdapter.notifyDataSetChanged()
    }

    fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
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
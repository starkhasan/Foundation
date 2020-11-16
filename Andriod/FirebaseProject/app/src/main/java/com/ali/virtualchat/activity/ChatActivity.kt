package com.ali.virtualchat.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ali.virtualchat.R
import com.ali.virtualchat.response.MessageResponse
import com.ali.virtualchat.utils.Preferences
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.message_area.*


class ChatActivity : AppCompatActivity(){

    val database = FirebaseDatabase.getInstance()
    var myRefSender = database.getReference().child("messages")
    var myRefReceiver = database.getReference().child("messages")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        Preferences.init(this@ChatActivity)

        val sender = intent.extras!!.get("Sender")
        val receiver = intent.extras!!.get("receiver")

        sendButton.setOnClickListener {
            val messages = messageArea.text.toString()
            if(!TextUtils.isEmpty(messages)){
                val map = HashMap<Any, Any>()
                map["message"] = messages
                map["user"] = Preferences.sender.toString()
                myRefSender.child(sender.toString()).push().setValue(map)
                myRefReceiver.child(receiver.toString()).push().setValue(map)
                messageArea.text.clear()
            }else{
                Toast.makeText(applicationContext, "Please type some messages", Toast.LENGTH_SHORT).show()
            }
        }

        myRefSender.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val messageResponse = snapshot.children.map { it.getValue(MessageResponse::class.java)!! }
                for (i in 0..messageResponse.size - 1) {
                    if (Preferences.sender == messageResponse.get(i).user)
                        addMessageBox("You :- \n" + messageResponse.get(i).message, 1)
                    else
                        addMessageBox(Preferences.receiver + " :- \n" + messageResponse.get(i).message, 2
                        )
                }
            }
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })

    }

    fun addMessageBox(message: String, type: Int){
        val textView = TextView(this@ChatActivity)
        textView.setText(message)
        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        lp.setMargins(10, 10, 10, 10)
        if(type == 1)
            textView.setBackgroundResource(R.drawable.rounded_corner1)
        else
            textView.setBackgroundResource(R.drawable.rounded_corner2)
        layout1.addView(textView);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
}
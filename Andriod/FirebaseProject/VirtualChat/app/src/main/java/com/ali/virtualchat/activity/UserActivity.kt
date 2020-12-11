package com.ali.virtualchat.activity

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.virtualchat.R
import com.ali.virtualchat.adapter.UserAdapter
import com.ali.virtualchat.utils.Helper
import com.ali.virtualchat.utils.Preferences
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.layout_heading.*
import kotlinx.android.synthetic.main.row_user.*
import java.io.FileNotFoundException
import java.io.InputStream

class UserActivity : AppCompatActivity(){

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference().child("users")
    val listUser = ArrayList<String>()
    val listImage = ArrayList<String>()
    var userAdapter : UserAdapter ?= null
    var base64Image = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(R.layout.activity_user)
        progressBar.visibility = View.VISIBLE
        Preferences.init(this@UserActivity)
        val popup_menu = PopupMenu(this@UserActivity,ivMore)
        popup_menu.menuInflater.inflate(R.menu.popup_menu,popup_menu.menu)

        val currentUser = Preferences.sender
        val menuOptions = popup_menu.menu
        menuOptions.getItem(0).setTitle(currentUser)

        if(Helper.isNetworkConnected(this@UserActivity)){
            myRef.addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    progressBar.visibility = View.GONE
                    listUser.clear()
                    listImage.clear()
                    if(snapshot.value!=null){
                        for(data in snapshot.children){
                            if(data.key.toString() != currentUser){
                                listUser.add(data.key.toString())
                                //listImage.add(data.child("image").value.toString())
                            }
                        }
                    }else{
                        AlertDialog.Builder(this@UserActivity,R.style.AlertDialogTheme)
                            .setMessage("User not Registered")
                            .setPositiveButton(R.string.register){dialog:DialogInterface,int:Int ->
                                Preferences.is_login = false
                                Preferences.rememberme = false
                                val intent = Intent(this@UserActivity,RegisterActivity::class.java)
                                intent.putExtra("From","UserActivity")
                                startActivity(intent)
                                finish()
                                dialog.dismiss()
                            }
                            .show()
                    }

                    val linearLayoutManager = LinearLayoutManager(this@UserActivity,LinearLayoutManager.VERTICAL,false)
                    rvUser.layoutManager = linearLayoutManager
                    userAdapter = UserAdapter(this@UserActivity,listUser){position:Int,OPERATION:String ->
                        if(OPERATION == "Chat"){
                            Preferences.receiver = listUser[position]
                            val sender = currentUser.toString()+"_"+listUser[position]
                            val receiver = listUser[position]+"_"+currentUser.toString()
                            val intent = Intent(this@UserActivity,ChatActivity::class.java)
                            intent.putExtra("Sender",sender)
                            intent.putExtra("receiver",receiver)
                            startActivity(intent)
                        }
                    }
                    if(listUser.size > 0)
                        tvUserNotFound.visibility = View.GONE
                    else
                        tvUserNotFound.visibility = View.VISIBLE
                    rvUser.adapter = userAdapter
                }
                override fun onCancelled(error: DatabaseError) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(applicationContext,"Couldn't get the user",Toast.LENGTH_SHORT).show()
                }
            })
        }else{
            AlertDialog.Builder(this,R.style.AlertDialogTheme)
                .setMessage(R.string.no_internet_connection)
                .setPositiveButton(R.string.ok){dialog:DialogInterface,int:Int ->
                    dialog.dismiss()
                }
                .show()
        }

        ivUser.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Upload Image")
                .setPositiveButton("Camera"){ dialog:DialogInterface,int:Int ->
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    try{
                        startActivityForResult(intent,2)
                    }catch (e:ActivityNotFoundException){}
                }
                .setNegativeButton("Gallery"){ dialog:DialogInterface,int:Int ->
                    val intent = Intent(Intent.ACTION_PICK)
                    intent.type = "image/*"
                    startActivityForResult(intent,1)
                }
                .show()
        }

        ivMore.setOnClickListener {
            popup_menu.setOnMenuItemClickListener(object:PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    if(item!!.title.toString() == "Logout"){
                        AlertDialog.Builder(this@UserActivity,R.style.AlertDialogTheme)
                            .setTitle(R.string.logout)
                            .setMessage("Are you sure you want to Logout?")
                            .setPositiveButton(R.string.yes){dialog:DialogInterface,int:Int ->
                                Preferences.is_login = false
                                Preferences.sender = ""
                                Preferences.receiver = ""
                                startActivity(Intent(this@UserActivity,LoginActivity::class.java))
                                finish()
                            }
                            .setNegativeButton(R.string.no){dialog:DialogInterface,int:Int ->
                                dialog.dismiss()
                            }
                            .show()
                    }else{
                        Toast.makeText(applicationContext,"Current user : "+item!!.title.toString(),Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
            popup_menu.show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode !== Activity.RESULT_OK)
        if (requestCode === 1) {
            try {
                val imageUri = data?.data!!
                val imageStream: InputStream? = contentResolver.openInputStream(imageUri)
                val image = BitmapFactory.decodeStream(imageStream)//this is bitmap image
                ivUser.setImageBitmap(image)
                base64Image = Helper.imagetobase64(image)
                myRef.child(Preferences.sender.toString()).child("image").setValue(base64Image)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(UserActivity@this,"Couldn't found image", Toast.LENGTH_LONG).show()
            }
        }
        if(requestCode === 2){
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            base64Image = Helper.imagetobase64(imageBitmap)
            ivUser.setImageBitmap(imageBitmap)
            myRef.child(Preferences.sender.toString()).child("image").setValue(base64Image)
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this,R.style.AlertDialogTheme)
            .setTitle(R.string.exit)
            .setMessage("Are you sure you want to Exit?")
            .setPositiveButton(R.string.yes){dialog:DialogInterface,int:Int ->
                dialog.dismiss()
                super.onBackPressed()
            }
            .setNegativeButton(R.string.no){dialog:DialogInterface,int:Int ->
                dialog.dismiss()
            }
            .show()
    }
}
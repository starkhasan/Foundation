package com.ceryl.ceryl.activity

import android.R.attr
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.ceryl.ceryl.R
import com.ceryl.ceryl.app.ConnectivityReceiver
import com.ceryl.ceryl.app.RegisterAbstractActivity
import com.ceryl.ceryl.network.ApiCallService
import com.ceryl.ceryl.network.response.GeneralResponse
import com.ceryl.ceryl.network.response.User.UserResponse
import com.ceryl.ceryl.network.response.profile.ProfileResponse
import com.ceryl.ceryl.util.*
import kotlinx.android.synthetic.main.activity_profile.*
import org.greenrobot.eventbus.Subscribe
import java.io.FileNotFoundException
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList


class ProfileActivity : RegisterAbstractActivity() {

    var appUser = AppUser()
    var base64Image = ""
    var stateList = arrayOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocalRepositories.saveAppUser(this,appUser)

        stateList = resources.getStringArray(R.array.indian_states)
        val arrayAdapter = ArrayAdapter.createFromResource(this,R.array.indian_states,R.layout.spinner_item)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_drop_down)
        spnrState.adapter = arrayAdapter

        apiGetProfile()
        rlUpdate.setOnClickListener {
            Helper.hideKeyboard(ProfileActivity@this)
            if(validation()){
                if(ConnectivityReceiver().isConnected()){
                    rotateloading.start()
                    val fullName = etFullName.text.toString().split(" ")
                    appUser!!.profileUpdate.put("email",etEmail.text.toString())
                    appUser!!.profileUpdate.put("first_name",fullName[0])
                    appUser!!.profileUpdate.put("last_name",fullName[1])
                    appUser!!.profileUpdate.put("phone",etPhone.text.toString())
                    appUser!!.profileUpdate.put("image",base64Image)
                    appUser!!.profileUpdate.put("birthday",etBirthday.text.toString())
                    appUser!!.profileUpdate.put("address1",etAddress1.text.toString())
                    appUser!!.profileUpdate.put("pincode",etPin.text.toString())
                    appUser!!.profileUpdate.put("address2",etAddress2.text.toString())
                    appUser!!.profileUpdate.put("state",spnrState.selectedItem)
                    LocalRepositories.saveAppUser(this,appUser)
                    ApiCallService.action(applicationContext,Cv.ACTION_UPDATE_PROFILE)
                }else{
                    Helper.snackbar_alert(ProfileActivity@this,getString(R.string.no_internet_connection),rlProfileParent)
                }
            }
        }

        etBirthday.setOnClickListener {
            Helper.hideKeyboard(ProfileActivity@this)
            datepicker()
        }

        rlDelete.setOnClickListener {
            AlertDialog.Builder(ProfileActivity@this)
                .setTitle("Delete User")
                .setMessage("Are you sure want to delete?")
                .setCancelable(false)
                .setNegativeButton("No"){
                    dialog, which -> dialog.dismiss()
                }
                .setPositiveButton("Yes") {
                        dialog, which -> apiDeleteUser()
                }
                .show()
        }

        rlEditImage.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Upload Image")
                .setPositiveButton("Camera") { dialogInterface: DialogInterface, i: Int ->
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    try {
                        startActivityForResult(intent,2)
                    }catch (e:ActivityNotFoundException){}
                }
                .setNegativeButton("Gallery") { dialogInterface:DialogInterface, i:Int ->
                    val intent = Intent(Intent.ACTION_PICK)
                    intent.type = "image/*"
                    startActivityForResult(intent, 1)
                }
                .show()
        }

        etFullName.setOnClickListener {
            val fullName = etFullName.text.toString().split(" ")
            etFirstName.setText(fullName[0])
            etLastName.setText(fullName[1])
            llName.visibility = View.VISIBLE
            etFullName.visibility = View.GONE
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode !== Activity.RESULT_OK) {
            return
        }
        if (requestCode === 1) {
            try {
                val imageUri = data?.data!!
                val imageStream: InputStream? = contentResolver.openInputStream(imageUri)
                val image = BitmapFactory.decodeStream(imageStream)//this is bitmap image
                base64Image = Helper.imagetobase64(image)
                ivProfile.setImageBitmap(image)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(ProfileActivity@this,"Couldn't found image", Toast.LENGTH_LONG).show()
            }
        }
        if(requestCode === 2){
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            base64Image = Helper.imagetobase64(imageBitmap)
            ivProfile.setImageBitmap(imageBitmap)
        }
    }


    fun apiDeleteUser(){
        if(ConnectivityReceiver().isConnected()){
            appUser!!.email = etEmail.text.toString()
            LocalRepositories.saveAppUser(this,appUser)
            ApiCallService.action(applicationContext,Cv.ACTION_DELETE_USER)
        }else{
            Helper.snackbar_alert(ProfileActivity@this,getString(R.string.no_internet_connection),rlProfileParent)
        }
    }

    fun apiGetProfile(){
        if(ConnectivityReceiver().isConnected()){
            rotateloading.start()
            appUser?.logindata?.put("email",Preferences.email.toString())
            LocalRepositories.saveAppUser(this,appUser)
            ApiCallService.action(applicationContext, Cv.ACTION_PROFILE)
        }else{
            Helper.snackbar_alert(ProfileActivity@this,getString(R.string.no_internet_connection),rlProfileParent)
        }
    }

    @Subscribe
    fun getProfile(response: ProfileResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.status == 200){
            Toast.makeText(applicationContext,response.message,Toast.LENGTH_SHORT).show()
            etFirstName.setText(response.Profile.first_name)
            etLastName.setText(response.Profile.last_name)
            val fullName = response.Profile.first_name+" "+response.Profile.last_name
            etFullName.setText(fullName)
            etEmail.setText(response.Profile.email)
            etBirthday.setText(response.Profile.birthday)
            etAddress1.setText(response.Profile.address1)
            etAddress2.setText(response.Profile.address2)
            if(response.Profile.phone.toString() != "0")
                etPhone.setText(response.Profile.phone.toString())
            if(response.Profile.pincode != "0")
                etPin.setText(response.Profile.pincode)
            var position = 0
            for (i in 0..stateList.size){
                if(response.Profile.state == stateList[i]){
                    position = i
                    break
                }
            }
            spnrState.setSelection(position)
            base64Image = response.Profile.image
            val bitmapImage:Bitmap  = Helper.base64toImage(response.Profile.image)
            ivProfile.setImageBitmap(bitmapImage)
        }else{
            Helper.snackbar_alert(ProfileActivity@this,response.message,rlProfileParent)
        }
    }

    @Subscribe
    fun deleteUser(response: UserResponse){
        if(rotateloading.isStart){
            rotateloading.stop()
        }
        if(response.status == 200){
            Toast.makeText(applicationContext,response.message,Toast.LENGTH_SHORT).show()
            Preferences.isLogin = false
            startActivity(Intent(ProfileActivity@this,SignUpActivity::class.java))
            finish()
        }else{
            Helper.snackbar_alert(ProfileActivity@this,response.message,rlProfileParent)
        }
    }

    @Subscribe
    fun updateProfile(respose:GeneralResponse){
        if(rotateloading.isStart)
            rotateloading.stop()
        if(respose.status == 200) {
            etFullName.setText(etFirstName.text.toString()+" "+etLastName.text.toString())
            etFullName.visibility = View.VISIBLE
            llName.visibility = View.GONE
            Helper.snackbar_info(ProfileActivity@ this, respose.message, rlProfileParent)
        }else
            Helper.snackbar_alert(ProfileActivity@this,respose.message,rlProfileParent)
    }

    private fun datepicker(){
        val mcurrentDate: Calendar = Calendar.getInstance()
        val year= mcurrentDate.get(Calendar.YEAR)
        val month= mcurrentDate.get(Calendar.MONTH)
        val day= mcurrentDate.get(Calendar.DAY_OF_MONTH)
        val mDatePicker = DatePickerDialog(ProfileActivity@this, DatePickerDialog.OnDateSetListener { _, years: Int, monthOfYear, dayOfMonth ->
            etBirthday.setText(""+dayOfMonth+"/"+(monthOfYear+1)+"/"+ years)
        }, year, month, day)
        mDatePicker.datePicker.maxDate = mcurrentDate.timeInMillis
        mDatePicker.show()
    }

    fun validation():Boolean{
        if(etFullName.visibility != View.VISIBLE){
            if(TextUtils.isEmpty(etFirstName.text)){
                Helper.snackbar_alert(ProfileActivity@this,"Please provide first name",rlProfileParent)
                return false
            }else if(TextUtils.isEmpty(etLastName.text)){
                Helper.snackbar_alert(ProfileActivity@this,"Please provide last name",rlProfileParent)
                return false
            }else{
                etFullName.setText(etFirstName.text.toString()+" "+etLastName.text.toString())
                return true
            }
        }else if(TextUtils.isEmpty(etPhone.text)){
            Helper.snackbar_alert(ProfileActivity@this,"Please provide phone number",rlProfileParent)
            return false
        }else if(etPhone.text.length!=10){
            Helper.snackbar_alert(ProfileActivity@this,"Please provide valid phone number",rlProfileParent)
            return false
        }else if(TextUtils.isEmpty(etBirthday.text)){
            Helper.snackbar_alert(ProfileActivity@this,"Please provide birth date",rlProfileParent)
            return false
        }else if(TextUtils.isEmpty(etAddress1.text)){
            Helper.snackbar_alert(ProfileActivity@this,"Please provide address",rlProfileParent)
            return false
        }else if(TextUtils.isEmpty(etPin.text)){
            Helper.snackbar_alert(ProfileActivity@this,"Please provide zip code",rlProfileParent)
            return false
        }else if(etPin.text.length!=6){
            Helper.snackbar_alert(ProfileActivity@this,"Please provide valid zip code",rlProfileParent)
            return false
        } else if(spnrState.selectedItem == "Please select state"){
            Helper.snackbar_alert(ProfileActivity@this,"Please select valid state",rlProfileParent)
            return false
        }else{
            return true;
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_profile
    }

    @Subscribe
    fun timeout(msg: String) {
        if (rotateloading.isStart) {
            rotateloading.stop()
        }
        Helper.snackbar_alert(LoginActivity@this, Cv.TIMEOUT,rlProfileParent)
    }
}
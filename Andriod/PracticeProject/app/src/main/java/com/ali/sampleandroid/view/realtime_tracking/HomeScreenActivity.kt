package com.ali.sampleandroid.view.realtime_tracking

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.ActivityHomeScreenBinding
import com.ali.sampleandroid.view.GoogleMapActivity
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeScreenActivity : AppCompatActivity() {

    lateinit var activityHomeScreenBinding: ActivityHomeScreenBinding
    val firebaseDB = Firebase.firestore
    lateinit var dialogRequest : Dialog
    lateinit var dialogResponse : Dialog
    lateinit var locationManager: LocationManager
    var senderRequestId = ""
    var userRequestId = ""
    val PERMISSION_REQUEST_CODE = 1
    var userName = ""
    var remoteName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Home Screen"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityHomeScreenBinding = ActivityHomeScreenBinding.inflate(LayoutInflater.from(this))
        setContentView(activityHomeScreenBinding.root)
        dialogResponse = Dialog(this)
        dialogRequest = Dialog(this)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        activityHomeScreenBinding.btnEnable.setOnClickListener {
            if(activityHomeScreenBinding.etAddress.text.isNotBlank()) {
                userRequestId = activityHomeScreenBinding.etAddress.text.toString()
                listenForFirebase()
                activityHomeScreenBinding.btnEnable.isEnabled = false
            }else{
                Toast.makeText(applicationContext,"Please provide id",Toast.LENGTH_SHORT).show()
            }
        }

        activityHomeScreenBinding.switchOnline.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked && senderRequestId.isNotBlank() && userRequestId.isNotBlank()) {
                locationManager.removeUpdates(mLocationListener)
                firebaseDB.collection("users").document(senderRequestId)
                    .update(hashMapOf("shareLocation" to false) as Map<String, Any>)
                    .addOnSuccessListener {
                        val data = hashMapOf(
                            "request" to false,
                            "requestStatus" to "none",
                            "online" to false,
                            "requestId" to "",
                            "shareLocation" to false,
                            "response" to false
                        )
                        firebaseDB.collection("users").document(userRequestId)
                            .update(data as Map<String, Any>)
                            .addOnSuccessListener {
                                activityHomeScreenBinding.llRemote.visibility = View.VISIBLE
                                activityHomeScreenBinding.llOnline.visibility = View.GONE
                            }
                            .addOnFailureListener {Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()}
                    }
                    .addOnFailureListener {Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()}
            }
        }

        activityHomeScreenBinding.btnConnect.setOnClickListener {
            if (validation() && userRequestId.isNotBlank()){
                senderRequestId = activityHomeScreenBinding.etRemoteAddress.text.toString()
                Firebase.firestore.collection("users").document(senderRequestId)
                    .update(
                        hashMapOf(
                            "requestId" to userRequestId,
                            "request" to true,
                            "requestStatus" to "waiting"
                        ) as Map<String, Any>
                    ).addOnSuccessListener {
                        Toast.makeText(this, "Request sent successfully", Toast.LENGTH_SHORT).show()
                        updateFirebaseData(userRequestId, hashMapOf("responseStatus" to "waiting", "response" to true))
                    }
                    .addOnFailureListener { Toast.makeText(this, "Request Failed", Toast.LENGTH_SHORT).show()}
                //responseStatus
            }else{
                Toast.makeText(applicationContext, "Invalid Remote Address", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if(userRequestId.isNotBlank()) listenForFirebase()
    }

    private fun validation() : Boolean{
        return if(activityHomeScreenBinding.etRemoteAddress.text.isBlank()){
            false
        }else if(activityHomeScreenBinding.btnEnable.isEnabled){
            Toast.makeText(applicationContext, "Please first connect with Cloud Firestore", Toast.LENGTH_SHORT).show()
            false
        }else activityHomeScreenBinding.etRemoteAddress.text.length == 6
    }

    private fun shareRealLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, mLocationListener)
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, mLocationListener)
                    }
                } else {
                    Toast.makeText(applicationContext, "Allow Permission for better result", Toast.LENGTH_SHORT).show()
                }
                return
            }
            else -> {
                // Ignore all other requests.
            }
        }
    }

    private val mLocationListener = LocationListener { location ->
        println("Latitude : ${location.latitude} Longitude : ${location.longitude}")
        if(senderRequestId.isNotBlank()) {
            firebaseDB.collection("users").document(senderRequestId)
                .update(hashMapOf("shareLocation" to true, "senderName" to userName, "userLocation" to GeoPoint(location.latitude, location.longitude)) as Map<String, Any>)
                .addOnSuccessListener {}
                .addOnFailureListener {
                    Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun listenForFirebase(){
        if(userRequestId.isNotBlank()) {
            Firebase.firestore.collection("users").document(userRequestId).addSnapshotListener { snapshot, e ->
                if (snapshot != null && snapshot.data != null && snapshot.exists()) {
                    val data = snapshot.data!!
                    userName = data["userName"] as String
                    if (data["request"] as Boolean) {
                        if (data["requestStatus"] == "waiting") {
                            senderRequestId = data["requestId"].toString()
                            dialogRemoteRequest()
                        } else if (data["requestStatus"] == "cancel" && dialogRequest.isShowing) {
                            dialogRequest.dismiss()
                            updateFirebaseData(
                                    userRequestId,
                                    hashMapOf(
                                            "request" to false,
                                            "requestStatus" to "none",
                                            "requestId" to ""
                                    ) as Map<String, Any>
                            )
                        }
                    }
                    if (data["online"] as Boolean) {
                        if (data["shareLocation"] as Boolean) {
                            activityHomeScreenBinding.switchOnline.isChecked = true
                            activityHomeScreenBinding.llRemote.visibility = View.GONE
                            activityHomeScreenBinding.llOnline.visibility = View.VISIBLE
                            shareRealLocation()
                        } else {
                            locationManager.removeUpdates(mLocationListener)
                            activityHomeScreenBinding.llRemote.visibility = View.VISIBLE
                            activityHomeScreenBinding.llOnline.visibility = View.GONE
                            activityHomeScreenBinding.switchOnline.isChecked = false
                            updateFirebaseData(userRequestId, hashMapOf("online" to false, "shareLocation" to false))
                        }
                    }
                    if (data["response"] as Boolean) {
                        if (data["responseStatus"] == "waiting") {
                            dialogRemoteResponse()
                        }
                        if (data["responseStatus"] == "cancel" && dialogResponse.isShowing) {
                            dialogResponse.dismiss()
                            updateFirebaseData(
                                    userRequestId,
                                    hashMapOf(
                                            "response" to false,
                                            "responseStatus" to "none",
                                            "requestId" to ""
                                    ) as Map<String, Any>
                            )
                        }
                        if (data["responseStatus"] == "accept" && dialogResponse.isShowing) {
                            if(userRequestId.isNotBlank() && senderRequestId.isNotBlank()){
                                dialogResponse.dismiss()
                                val intent = Intent(this, GoogleMapActivity::class.java)
                                intent.putExtra("userAddress", userRequestId)
                                intent.putExtra("remoteAddress", senderRequestId)
                                startActivity(intent)
                            }else{
                                Toast.makeText(applicationContext,"Invalid User and Remote Id",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }


    private fun dialogRemoteRequest(){
        dialogRequest.setContentView(R.layout.dialog_remote_request)
        val btnAccept = dialogRequest.findViewById<LinearLayout>(R.id.btnAccept)
        val btnCancel = dialogRequest.findViewById<LinearLayout>(R.id.btnCancel)
        btnAccept.setOnClickListener {
            dialogRequest.dismiss()
            if(senderRequestId.isNotBlank()){
                firebaseDB.collection("users").document(senderRequestId)
                    .update(hashMapOf("responseStatus" to "accept") as Map<String, Any>)
                    .addOnSuccessListener {
                        Toast.makeText(applicationContext, "Response Sent", Toast.LENGTH_SHORT).show()
                        updateFirebaseData(
                            userRequestId,
                            hashMapOf(
                                "request" to false,
                                "requestId" to "",
                                "requestStatus" to "none",
                                "online" to true,
                                "shareLocation" to true
                            ) as Map<String, Any>
                        )
                    }
                    .addOnFailureListener {Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()}
            }
        }
        btnCancel.setOnClickListener {
            dialogRequest.dismiss()
            if(senderRequestId.isNotBlank()){
                firebaseDB.collection("users").document(senderRequestId)
                    .update(hashMapOf("responseStatus" to "cancel") as Map<String, Any>)
                    .addOnSuccessListener {
                        Toast.makeText(applicationContext, "Response Sent", Toast.LENGTH_SHORT).show()
                        updateFirebaseData(
                            userRequestId,
                            hashMapOf(
                                "request" to false,
                                "requestId" to "",
                                "requestStatus" to "cancel",
                            ) as Map<String, Any>
                        )
                    }
                    .addOnFailureListener {Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()}
            }
        }
        dialogRequest.show()
        val window: Window = dialogRequest.getWindow()!!
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
    }

    private fun dialogRemoteResponse(){
        dialogResponse.setContentView(R.layout.dialog_remote_response)
        val btnCancel = dialogResponse.findViewById<LinearLayout>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            if(senderRequestId.isNotBlank() && userRequestId.isNotBlank()){
                dialogResponse.dismiss()
                firebaseDB.collection("users").document(senderRequestId)
                        .update(hashMapOf("requestStatus" to "cancel") as Map<String, Any>)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Request sent successfully", Toast.LENGTH_SHORT).show()
                            updateFirebaseData(userRequestId, hashMapOf("responseStatus" to "none", "response" to false))
                        }
                        .addOnFailureListener { Toast.makeText(this, "Request Failed", Toast.LENGTH_SHORT).show()}
            }else{
                Toast.makeText(this, "Invalid Sender and Receiver Id", Toast.LENGTH_SHORT).show()
            }
        }
        dialogResponse.show()
        val window: Window = dialogResponse.getWindow()!!
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
    }

    private fun updateFirebaseData(userId: String, userData: Map<String, Any>){
        firebaseDB.collection("users").document(userId)
            .update(userData)
            .addOnSuccessListener {
                Toast.makeText(applicationContext, "Updated Successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()
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
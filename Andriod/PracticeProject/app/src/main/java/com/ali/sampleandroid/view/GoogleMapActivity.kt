package com.ali.sampleandroid.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ali.sampleandroid.R
import com.ali.sampleandroid.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class GoogleMapActivity : AppCompatActivity() , OnMapReadyCallback{

    lateinit var googleMap: GoogleMap
    lateinit var markerUser: Marker
    lateinit var markerRemote: Marker
    private lateinit var activityMapBinding : ActivityMapBinding
    var markerCount = 1
    val handler = Handler(Looper.getMainLooper())
    val PERMISSION_REQUEST_CODE = 1
    val firebaseDB = Firebase.firestore
    var userAddress = ""
    var remoteAddress = ""
    var userName = ""
    var senderName = ""

    var listPosition = listOf(
        LatLng(25.568369, 84.684380),
        LatLng(25.567762, 84.684568),
        LatLng(25.568411, 84.686456),
        LatLng(25.568916, 84.687821),
        LatLng(25.569919, 84.688670),
        LatLng(25.569994, 84.689203),
        LatLng(25.569179, 84.688984),
        LatLng(25.567032, 84.688285),
        LatLng(25.565367, 84.687206),
        LatLng(25.564432, 84.686213),
        LatLng(25.562712, 84.683760),
        LatLng(25.559062, 84.678959),
        LatLng(25.558126, 84.677712),
        LatLng(25.558451, 84.677512),
        LatLng(25.558734, 84.677371),
        LatLng(25.558520, 84.676608),
        LatLng(25.558458, 84.676184),
        LatLng(25.558432, 84.674853)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userAddress = intent.extras!!["userAddress"].toString()
        remoteAddress = intent.extras!!["remoteAddress"].toString()
        activityMapBinding = ActivityMapBinding.inflate(LayoutInflater.from(this))
        setContentView(activityMapBinding.root)
        supportActionBar?.hide()
        locationPermission()

        activityMapBinding.llCancelAccess.setOnClickListener {
            firebaseDB.collection("users").document(remoteAddress)
                .update(hashMapOf("shareLocation" to false) as Map<String, Any>)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext, "Response Sent", Toast.LENGTH_SHORT).show()
                    firebaseDB.collection("users").document(userAddress)
                        .update(hashMapOf("online" to false,"shareLocation" to false,"senderName" to "") as Map<String, Any>)
                        .addOnSuccessListener {
                            finish()
                        }
                        .addOnFailureListener {Toast.makeText(applicationContext, "User Operation Failed", Toast.LENGTH_SHORT).show()}
                }
                .addOnFailureListener {Toast.makeText(applicationContext, " Remote Operation Failed", Toast.LENGTH_SHORT).show()}
        }
    }

    override fun onResume() {
        super.onResume()
        if(userAddress.isNotBlank() && remoteAddress.isNotBlank()){
            updateFirebaseData(
                    userAddress,
                    hashMapOf(
                            "response" to false,
                            "responseStatus" to "none",
                            "online" to true
                    ) as Map<String, Any>
            )
            listenforLocationChange(userAddress)
        }
    }

    private fun listenforLocationChange(userAddress : String){

        firebaseDB.collection("users").document(userAddress).addSnapshotListener { snapshot, e ->
            if(snapshot != null && snapshot.data != null && snapshot.exists()){
                val data = snapshot.data!!
                if(data["shareLocation"] as Boolean){
                    activityMapBinding.ivOnline.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.icon_dot_green))
                }else{
                    activityMapBinding.ivOnline.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.icon_dot_red))
                }
                if(data["userLocation"] != null){
                    val position = data["userLocation"] as GeoPoint
                    senderName = data["senderName"] as String
                    activityMapBinding.tvRemoteUser.text = senderName
                    if(!this@GoogleMapActivity::markerRemote.isInitialized){
                        markerRemote = googleMap.addMarker(
                                MarkerOptions()
                                        .position(LatLng(position.latitude,position.longitude))
                                        .title(senderName)
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                        )!!
                    }else{
                        markerRemote.position = LatLng(position.latitude,position.longitude)
                    }
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(markerRemote.position,19f))
                }
            }
        }
    }

    private fun locationPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),PERMISSION_REQUEST_CODE)
        }else{
            loadMap()
        }
    }

    private fun updateFirebaseData(userId: String,userData: Map<String, Any>){
        firebaseDB.collection("users").document(userId)
            .update(userData).addOnSuccessListener {
                Toast.makeText(applicationContext, "Updated Successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Operation Failed", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission is granted. Continue the action or workflow
                    loadMap()
                } else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    Toast.makeText(applicationContext,"Allow Permission for better result",Toast.LENGTH_SHORT).show()
                }
                return
            }
            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }


    val runnable = object : Runnable {
        override fun run() {
            if (markerCount < listPosition.size) {
                markerUser.position = listPosition[markerCount++]
                val newCamPos = CameraPosition(
                    markerUser.position,
                    19f,
                    60f,
                    30f
                )
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(newCamPos))
                handler.postDelayed(this, 1500)
            }
        }
    }

    fun loadMap(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        googleMap.uiSettings.isMapToolbarEnabled = false
        googleMap.uiSettings.isZoomControlsEnabled = false
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            googleMap.isMyLocationEnabled = true
        }
        markerUser = googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(25.568369, 84.684380))
                .title(userName)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        )!!
        val newCamPos = CameraPosition(LatLng(25.568369, 84.684380),19f,map.cameraPosition.tilt,map.cameraPosition.bearing)
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(newCamPos))

        /*
        *Code for Draw polyline between the list of LatLng
        val polyline1 = googleMap.addPolyline(PolylineOptions().addAll(listPosition))
        polyline1.color = ContextCompat.getColor(this,R.color.black)
        polyline1.tag = "First Polyline"
        polyline1.width = 8f*/
    }
}
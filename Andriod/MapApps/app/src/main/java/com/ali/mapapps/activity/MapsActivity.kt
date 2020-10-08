package com.ali.mapapps.activity

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ali.mapapps.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    var locationManager: LocationManager? = null
    val listMarker = ArrayList<LatLng>()
    companion object {
        const val REQUEST_CODE = 0xABC
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        listMarker.add(LatLng(-35.016, 143.321))
        listMarker.add(LatLng(-34.747, 145.592))
        listMarker.add(LatLng(-34.364, 147.891))
        listMarker.add(LatLng(-33.501, 150.217))
        listMarker.add(LatLng(-32.306, 149.248))
        listMarker.add(LatLng(-32.491, 147.309))

        btnMyLocation.setOnClickListener {
            checkPermission()
        }

        fab.setOnClickListener {
            startActivity(Intent(MapsActivity@this,WeatherActivity::class.java))
        }
    }

    fun checkPermission(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.isMyLocationEnabled = true
            locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isNetworkEnabled = locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            val isGpsEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
            if(isGpsEnabled){
                val locationGPS = locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if(locationGPS!=null){
                    val latitude = locationGPS!!.latitude
                    val longitude = locationGPS!!.longitude
                    Toast.makeText(applicationContext,latitude.toString()+" "+longitude.toString(),Toast.LENGTH_SHORT).show()
                    mMap.clear()
                    mMap.isBuildingsEnabled = true
                    mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                    val sydney = LatLng(latitude,longitude)
                    mMap.addMarker(MarkerOptions()
                        .position(sydney)
                        .title("Home")
                        .snippet("Ali Hasan Home Location")
                        .alpha(1.0f)
                    )
                    val cameraPosition = CameraPosition.Builder()
                        .target(sydney)
                        .zoom(15f)
                        .bearing(90f)
                        .build()

                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                    //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
                }
            }else{
                Toast.makeText(applicationContext,"Please Enbled the GPS",Toast.LENGTH_SHORT).show()
            }
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),
                REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return
                    }
                    mMap.isMyLocationEnabled = true
                    locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    val isNetworkEnabled = locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                    val isGpsEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
                    if(isGpsEnabled){
                        val locationGPS = locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                        val latitude = locationGPS!!.latitude
                        val longitude = locationGPS!!.longitude
                        Toast.makeText(applicationContext,latitude.toString()+" "+longitude.toString(),Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext,"Please Enbled the GPS",Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val dialogBuilder = AlertDialog.Builder(this)
                    dialogBuilder.setTitle("Ali Hasan")
                    dialogBuilder.setMessage("Please grant the permission for better result")
                    dialogBuilder.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                        Toast.makeText(applicationContext,"Ok",Toast.LENGTH_SHORT).show()
                    }
                    dialogBuilder.create().show()
                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney = LatLng(-34.0, 151.0)
        mMap.addPolyline(PolylineOptions()
            .addAll(listMarker)
            .width(5f)
            .color(Color.RED)
        )
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
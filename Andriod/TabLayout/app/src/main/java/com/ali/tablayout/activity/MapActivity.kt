package com.ali.tablayout.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ali.tablayout.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() , OnMapReadyCallback {

    private var googleMap: GoogleMap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }
    override fun onMapReady(p0: GoogleMap?) {
        googleMap=p0
        val latLng = LatLng(28.6139,77.2090)
        val markerOptions: MarkerOptions = MarkerOptions().position(latLng).title("New Delhi")

        val zoomLevel = 12.0f //This goes up to 21

        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        }
    }
}
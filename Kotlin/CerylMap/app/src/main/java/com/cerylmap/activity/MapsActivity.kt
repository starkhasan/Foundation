package com.cerylmap.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.cerylmap.R
import TaskLoadedCallback
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback , TaskLoadedCallback {

    private lateinit var mMap: GoogleMap
    lateinit var place1: MarkerOptions
    lateinit var place2: MarkerOptions
    lateinit var btn:Button
    var currentPolyline: Polyline? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            FetchURL(this@MapsActivity)
                .execute(getUrl(place1.position, place2.position, "driving"), "driving")
        }

        place1=MarkerOptions().position(LatLng(28.386563,77.310145)).title("My Location")
        place2=MarkerOptions().position(LatLng(28.612926,77.229602)).title("India Gate")

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this@MapsActivity)
    }

    private fun getUrl(origin: LatLng, dest: LatLng, directionMode: String): String? { // Origin of route
        val str_origin = "origin=" + origin.latitude + "," + origin.longitude
        // Destination of route
        val str_dest = "destination=" + dest.latitude + "," + dest.longitude
        // Mode
        val mode = "mode=$directionMode"
        // Building the parameters to the web service
        val parameters = "$str_origin&$str_dest&$mode"
        // Output format
        val output = "json"
        // Building the url to the web service
        return "https://maps.googleapis.com/maps/api/directions/$output?$parameters&key=AIzaSyBcFpWT7vu4mLXbEPmkr5GJDG5jWBI67x0"
//https://maps.googleapis.com/maps/api/directions/json?origin=28.386563,77.310145&destination=28.612926,77.229602&mode=driving&key=AIzaSyBcFpWT7vu4mLXbEPmkr5GJDG5jWBI67x0  //JoltCRM API KEY
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(28.386563, 77.310145)
        val mylocation = LatLng(place1.position.latitude,place1.position.longitude)
        mMap.addMarker(place1)
        mMap.addMarker(place2)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylocation))
    }


    override fun onTaskDone(vararg values: PolylineOptions?) {
        if (currentPolyline != null)
            currentPolyline!!.remove();
        currentPolyline = mMap.addPolyline(values[0])

        /*currentPolyline = mMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .add(
                    LatLng(-35.016, 143.321),
                    LatLng(-34.747, 145.592),
                    LatLng(-34.364, 147.891),
                    LatLng(-33.501, 150.217),
                    LatLng(-32.306, 149.248),
                    LatLng(-32.491, 147.309)))*/
    }
}



//28.386563, 77.310145  my current location Bata Chowk Fridabad

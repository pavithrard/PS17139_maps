package com.example.ps17139_maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.ps17139_maps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var uniMap: Map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uniMap=intent.getSerializableExtra("Uni_name") as Map
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val boundsbulider= LatLngBounds.Builder()
        for (uni in uniMap.places){
            val latLng=LatLng(uni.latitude,uni.longitude)
            boundsbulider.include(latLng)
            mMap.addMarker(MarkerOptions().position(latLng).title(uni.title))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,17f))
        }

    }
}
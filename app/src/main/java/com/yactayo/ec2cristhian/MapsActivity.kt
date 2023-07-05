package com.yactayo.ec2cristhian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yactayo.ec2cristhian.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback{
    private lateinit var binding: ActivityMapsBinding
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fragMap) as SupportMapFragment
        fragmentMap.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val localizacion1 = LatLng(-12.065976958771802, -77.03687777204739)
        googleMap.addMarker(MarkerOptions().position(localizacion1).title("UTP - Torre Arequipa"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion1))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacion1, 16f))

        val localizacion2 = LatLng(-12.063857670379361, -77.03462212899208)
        googleMap.addMarker(MarkerOptions().position(localizacion2).title("Universidad Privada Telesup"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion2))

        val localizacion3 = LatLng(-12.06748763876778, -77.03577908600089)
        googleMap.addMarker(MarkerOptions().position(localizacion3).title("Universidad Tecnológica Del Perú - FACO - Sede Petit Thouars"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion3))


    }

}
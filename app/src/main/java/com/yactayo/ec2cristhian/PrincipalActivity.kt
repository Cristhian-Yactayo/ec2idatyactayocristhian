package com.yactayo.ec2cristhian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yactayo.ec2cristhian.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button()

    }

    private fun button(){

        binding.btn1.setOnClickListener {
            Toast.makeText(this, "Bienvenid@ a la funcion de Camara", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CamaraActivity::class.java)
            startActivity(intent)
        }

        binding.btn2.setOnClickListener {
            Toast.makeText(this, "Bienvenid@ a la funcion de Maps", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

    }
}
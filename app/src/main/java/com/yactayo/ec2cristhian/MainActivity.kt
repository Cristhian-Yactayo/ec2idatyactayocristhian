package com.yactayo.ec2cristhian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.yactayo.ec2cristhian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()

    }

    private fun setupViews(){
        binding.txtEmail.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled = validateImputs(text.toString(), binding.txtPassword.editText?.text.toString())
        }
        binding.txtPassword.editText?.addTextChangedListener { text ->
            binding.btnLogin.isEnabled = validateImputs(binding.txtEmail.editText?.text.toString(), text.toString())
        }
        binding.btnLogin.setOnClickListener {
            val email = binding.txtEmail.editText?.text.toString()
            val pass = binding.txtPassword.editText?.text.toString()

            if (email.equals("ejemplo@idat.edu.pe") && pass.equals("123456")){

                Toast.makeText(this, "Sesion Iniciada", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PrincipalActivity::class.java)
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this, "Correo y/o Contraseña Incorrectos", Toast.LENGTH_SHORT).show()
            }


        }
    }

    private fun validateImputs(email: String, password: String): Boolean{
        val isEmailOk = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordOk = password.length >= 4
        return isPasswordOk && isEmailOk
    }


}
package com.example.app1cet35

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app1cet35.databinding.ActivityRecupBinding
import com.google.firebase.auth.FirebaseAuth

class activityRecup : AppCompatActivity() {

    private val binding by lazy { ActivityRecupBinding.inflate(layoutInflater) }

    private val auth by lazy{ FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRecuperarSenha.setOnClickListener {

            val email = binding.edtEmailRecuperacao.text.toString().trim()

            auth.sendPasswordResetEmail(email)
                .addOnSuccessListener {
                    Toast.makeText(this, "Por favor verifique o seu email", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Erro ao enviar  email", Toast.LENGTH_LONG).show()
                }
        }

    }
}
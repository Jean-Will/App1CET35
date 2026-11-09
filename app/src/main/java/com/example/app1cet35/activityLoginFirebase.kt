package com.example.app1cet35

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app1cet35.databinding.ActivityLoginFirebaseBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.jvm.java

class activityLoginFirebase : AppCompatActivity() {



    private val binding by lazy { ActivityLoginFirebaseBinding.inflate(layoutInflater) }

    private val auth by lazy{ FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root) // TROCAR SEMPRE @@#@#@#@#@
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.txtCriarConta.setOnClickListener {
            val i = Intent(this, activityCreat::class.java)
            startActivity(i)
        }

        binding.txtEsqueceuSenha.setOnClickListener {
            val i = Intent(this, activityRecup::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val pass = binding.edtSenha.text.toString().trim()

            auth.signInWithEmailAndPassword(email, pass)
                .addOnSuccessListener {
                    if (auth.currentUser?.isEmailVerified() == true){
                        Toast.makeText(this, "Login efetuado com Seucesso ", Toast.LENGTH_LONG).show()
                        val i = Intent(this, activityApp::class.java)
                        // put extra para mandar o nome
                        startActivity(i)
                    }else{
                        Toast.makeText(this, "Login efetuado com Seucesso ", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Erro no Login ", Toast.LENGTH_LONG).show()
                }


        }

    }
}
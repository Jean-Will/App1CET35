package com.example.app1cet35

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app1cet35.databinding.ActivityCreatBinding
import com.example.app1cet35.databinding.ActivityLoginFirebaseBinding
import com.google.firebase.auth.FirebaseAuth

class activityCreat : AppCompatActivity() {

    private val binding by lazy { ActivityCreatBinding.inflate(layoutInflater) }

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

        val nome = binding.edtNome.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val pass = binding.edtSenha.text.toString().trim()
        val confPass = binding.edtConfirmarSenha.text.toString().trim()

        if (pass!=confPass){
            Toast.makeText(this,"As pass devem ser iguais", Toast.LENGTH_LONG ).show()
        }else{
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnSuccessListener {
                    Toast.makeText(this, "Registo com Seucesso ", Toast.LENGTH_LONG).show()
                    auth.currentUser?.sendEmailVerification()
                    val i = Intent(this, activityLoginFirebase::class.java)
                    startActivity(i )

                }
                .addOnFailureListener{
                    Toast.makeText(this, " Erro no registo", Toast.LENGTH_LONG ).show()
                }
        }

    }
}
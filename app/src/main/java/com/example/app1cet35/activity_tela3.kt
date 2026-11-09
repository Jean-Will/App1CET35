package com.example.app1cet35

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app1cet35.databinding.ActivityTela3Binding

class activity_tela3 : AppCompatActivity() {

    private val binding by lazy { ActivityTela3Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root) // TROCA AQUI PARA BINDING.ROOT SEMPRE !!@#@#@$@@#!#
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pizza1 = findViewById<ImageView>(R.id.imgPizza1)
        val pizza2 = findViewById<ImageView>(R.id.imgPizza2)
        val pizza3 = findViewById<ImageView>(R.id.imgPizza3)

        pizza1.setOnClickListener {
            binding.tvEscolha.text="Escolheu a Pizza 1 !"
        }

        pizza2.setOnClickListener {
            binding.tvEscolha.text="Escolheu a Pizza 2 !"
        }

        pizza3.setOnClickListener {
            binding.tvEscolha.text="Escolheu a Pizza 3 !"
        }

        val i = intent
        val nome = i.getStringExtra("nome")
        binding.tvNome.text = nome
    }
}
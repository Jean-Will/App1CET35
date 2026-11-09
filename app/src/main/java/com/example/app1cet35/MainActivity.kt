package com.example.app1cet35

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app1cet35.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalcular.setOnClickListener {
            calcularMedia()
        }




    }

    private fun calcularMedia() {
        var numero1 = binding.etNumero1.text.toString().toDoubleOrNull()
        var numero2 = binding.etNumero2.text.toString().toDoubleOrNull()

        if (numero1 == null){
            numero1 = 0.0
        }

        if (numero2 == null){
            numero2 = 0.0
        }

        val soma = numero1 + numero2

         var media = soma /2

        if(media >10){
            Toast.makeText(this,"Aprovado", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Reprovado", Toast.LENGTH_LONG).show()
        }

        binding.tvResultado.text = soma.toString()

    }
}
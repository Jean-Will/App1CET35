package com.example.app1cet35

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app1cet35.databinding.ActivityMainBinding
import com.example.app1cet35.databinding.ActivityTela2Binding

class activityTela2 : AppCompatActivity() {

    private val binding by lazy { ActivityTela2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnContinuar.setOnClickListener() {
            if (validarForm()) {
                mostrarInfo()
            }
            val nome = binding.etNome.text.toString() // VARIVALE PARA ENVIAR PRA OUTRA JANELA
            val intent = Intent(this, activity_tela3::class.java)
            intent.putExtra("nome",nome)// PARA PASSAR VALOR P/OUTRA JANELA

            startActivity(intent)
        }
    }

    private fun mostrarInfo() {

        val nome = binding.etNome.text.toString()
        val sexoId = binding.rbSexo.checkedRadioButtonId
        val sexo = when(sexoId){
            binding.rbMasculino.id->"Masculino"
            binding.rbFeminino.id->"Feminino"
            binding.rbOutro.id->"Outro"
            else -> "Sexo Errado!"
        }

        val passaTempos = mutableListOf<String>()
        if (binding.cbNadar.isChecked) passaTempos.add(  "Nadar")
        if (binding.cbCorrer.isChecked) passaTempos.add( "Correr")
        if (binding.cbPassear.isChecked) passaTempos.add("Passear")
        if (binding.cbSaltar.isChecked) passaTempos.add( "Saltar")

        val mensagem ="""
            Nome: $nome
            Sexo: $sexo
            Passatempo: ${passaTempos.joinToString(",")}
        """.trimIndent()

        binding.tvInformacao.text = mensagem

    }

    private fun validarForm(): Boolean{

            val nome = binding.etNome.text.toString().trim()

            if (nome.isEmpty()){
                binding.etNome.error="Por favor, introduza o seu nome"

                binding.etNome.requestFocus()
                return false
            }

            if (binding.rbSexo.checkedRadioButtonId == -1){
                Toast.makeText(this,"Por favor escolha um Sexo!", Toast.LENGTH_LONG).show()
                binding.rbSexo.requestFocus()
                return false
            }


            return true
        }


    }

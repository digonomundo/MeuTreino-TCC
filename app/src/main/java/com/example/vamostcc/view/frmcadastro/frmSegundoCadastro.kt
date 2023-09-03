package com.example.vamostcc.view.home

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.text.NumberFormat
import java.util.Locale
import android.widget.Toast
import com.example.vamostcc.databinding.ActivityHomeBinding
import com.example.vamostcc.view.telausuario.telaUsuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var auth = FirebaseAuth.getInstance()
    private var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
       supportActionBar?.hide()


        binding.btnSalvarDados.setOnClickListener { view ->
            val nome = binding.edtNome.text.toString()
            val strPeso = binding.edtPeso.text.toString()
            val strAltura  = binding.edtAltura.text.toString()
            val idade = binding.edtIdade.text.toString()


            if (nome.isEmpty() ||  strPeso.isEmpty() || strAltura.isEmpty() || idade.isEmpty()) {
                val avisoVazio =
                    Snackbar.make(view, "Preencha todos os Campos", Snackbar.LENGTH_SHORT)
                avisoVazio.setBackgroundTint(Color.RED)
                avisoVazio.show()
            } else {

                val peso = strPeso.toDouble()
                val altura = strAltura.toDouble()
                val idade = idade.toInt()


                val usuariosMap = hashMapOf(
                    "nome" to (nome),
                    "peso" to (peso),
                    "altura" to (altura),
                    "idade" to (idade)
                )


                val idUser = FirebaseAuth.getInstance().currentUser!!.uid

                db.collection("usuarios").document(idUser).set(usuariosMap)
                    .addOnCompleteListener {

                        Log.d("db", "sucesso a salvar os dados do Usuario")

                    }.addOnFailureListener {
                        Toast.makeText(this, "falha", Toast.LENGTH_SHORT).show()

                    }


                    var entrar = Intent (this , telaUsuario::class.java)
                    startActivity(entrar)

            }
        }
    }
}
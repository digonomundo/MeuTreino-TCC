package com.example.vamostcc.view.telausuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vamostcc.R
import java.text.NumberFormat
import java.util.Locale
import com.example.vamostcc.databinding.ActivityTelaUsuarioBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.example.vamostcc.view.home.home
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore

class telaUsuario : AppCompatActivity() {
    private lateinit var binding: ActivityTelaUsuarioBinding

    private val auth = FirebaseAuth.getInstance()
    private var db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        val idUsuario = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("usuarios").document(idUsuario)

        ref.get().addOnSuccessListener {
            if (it != null) {
                val nome = it.data?.get("nome").toString()
                val peso : Double = it.data?.get("peso").toString().toDouble()
                val altura  : Double = it.data?.get("altura").toString().toDouble()
                val idade = it.data?.get("idade").toString().toInt()


                binding.txtNome.setText("olá $nome")
                binding.txtPeso.setText("Peso: $peso kg")
                binding.txtAltura.setText("Altura: $altura metros")
                binding.txtIdade.setText("Idade: $idade anos")


                fun calcularIMC(peso: Double, altura: Double): Double {
                    val imc = peso / (altura * altura)
                    return imc
                }


                val imc = calcularIMC(peso, altura)

               /* if (imc < 18.5) {
                    println("Abaixo do peso")
                } else if (imc >= 18.5 && imc < 24.9) {
                    println("Peso saudável")
                } else if (imc >= 25.0 && imc < 29.9) {
                    println("Sobrepeso")
                } else {
                    println("Obesidade")
                }*/


                fun formatarImc(imc: Double): String {
                    return String.format(Locale("pt", "BR"), "%.2f", imc)
                }
                    val numeroDouble = imc
                    val imcFormatado = formatarImc(numeroDouble)


                fun calcularAgua(peso:Double):Double{
                    val agua = (peso * 35) / 1000
                    return agua
                }

                val agua = calcularAgua(peso)

                fun formatarAgua(agua: Double): String {
                    return String.format(Locale("pt", "BR"), "%.2f", agua)
                }
                val aguaDouble = agua
                val aguaFormatado = formatarAgua(aguaDouble)





                binding.txtQtdAgua.setText("consumo de água diário: $aguaFormatado litros")


                binding.txtImc.setText("seu imc é: $imcFormatado")


            }

        }
            .addOnFailureListener{
                Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show()
            }





        binding.btnDeslogar.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val voltarFrmLogin = Intent(this, frmLogin :: class.java)
            startActivity(voltarFrmLogin)
            finish()
        }



    }

}
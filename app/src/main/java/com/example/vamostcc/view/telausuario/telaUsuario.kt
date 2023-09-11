package com.example.vamostcc.view.telausuario

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.*
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


                binding.txtNome.setText("$nome")
                binding.txtPeso.setText("$peso kg")
                binding.txtAltura.setText("$altura metros")
                binding.txtIdade.setText("$idade anos")

                fun calcularIMC(peso: Double, altura: Double): Double {
                    val imc = peso / (altura * altura)
                    return imc
                }

                val imc = calcularIMC(peso, altura)

                if (imc < 18.5) {
                    binding.txtResultadoImc.setText("você está Abaixo do peso")
                    binding.txtResultadoImc.setTextColor(RED)
                }
                else if (imc >= 18.5 && imc < 24.9) {
                    binding.txtResultadoImc.setText("você está com o peso Saudável")
                    binding.txtResultadoImc.setTextColor(GREEN)
                }
                else if (imc >= 25.0 && imc < 29.9) {
                    binding.txtResultadoImc.setText("você está Sobrepeso")
                    binding.txtResultadoImc.setTextColor(YELLOW)
                }
                else if (imc >= 30.0 && imc < 34.9) {
                    binding.txtResultadoImc.setText("você está começando a virar a Thais Carla")
                    binding.txtResultadoImc.setTextColor(RED)
                }
                else if (imc >= 35.0 && imc < 39.9) {
                    binding.txtResultadoImc.setText("você virou a Thais Carla")
                    binding.txtResultadoImc.setTextColor(RED)
                }
                else {
                    binding.txtResultadoImc.setText("você está pior que a Thais Carla")
                    binding.txtResultadoImc.setTextColor(RED)
                }


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

                binding.txtQtdAgua.setText("$aguaFormatado litros")

                binding.txtImc.setText("$imcFormatado")


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
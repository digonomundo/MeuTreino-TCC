package com.example.vamostcc.view.frmrecuperarsenha

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vamostcc.databinding.ActivityTelaRecuperarSenhaBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class telaRecuperarSenha : AppCompatActivity() {
    private lateinit var binding: ActivityTelaRecuperarSenhaBinding
    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaRecuperarSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.btnRecuperar.setOnClickListener { view ->

            val email = binding.edtEmail.text.toString()


            if (email.isEmpty()) {
                val teste = Snackbar.make(view, "Preencha todos os Campos", Snackbar.LENGTH_SHORT)
                teste.setBackgroundTint(Color.RED)
                teste.show()
            } else {
                auth.sendPasswordResetEmail(email).addOnSuccessListener {
                    Snackbar.make(view, "Enviamos o link no seu e-mail para a redefinição de senha", Snackbar.LENGTH_SHORT).setBackgroundTint(Color.GREEN).show()

                }.addOnFailureListener {
                    //Snackbar.make(view, it.toString(), Toast.LENGTH_SHORT).show()

                        exception ->
                    val msgDeErros = when (exception) {
                        is FirebaseAuthEmailException -> "Digite um Email cadastrado"
                        is FirebaseAuthInvalidUserException -> "Digite um Email cadastrado"
                        is FirebaseAuthException -> "Digite um Email válido"

                        else -> "falha"
                    }
                    Snackbar.make(view, msgDeErros, Snackbar.LENGTH_SHORT).setBackgroundTint(Color.RED).show()
                }



            }

        }

        binding.btnCancelar.setOnClickListener{
            val voltar = Intent(this, frmLogin::class.java)
            startActivity(voltar)
        }



    }
}
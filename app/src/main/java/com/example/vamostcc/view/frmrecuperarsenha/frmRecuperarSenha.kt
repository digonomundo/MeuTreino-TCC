package com.example.vamostcc.view.frmrecuperarsenha

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vamostcc.databinding.ActivityTelaRecuperarSenhaBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.google.android.material.snackbar.Snackbar

class telaRecuperarSenha : AppCompatActivity() {
    private lateinit var binding: ActivityTelaRecuperarSenhaBinding



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

            }

        }

        binding.btnCancelar.setOnClickListener{
            val voltar = Intent(this, frmLogin::class.java)
            startActivity(voltar)
        }



    }
}
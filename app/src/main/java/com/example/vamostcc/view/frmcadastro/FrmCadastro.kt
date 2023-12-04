package com.example.vamostcc.view.frmcadastro

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.vamostcc.databinding.ActivityFrmCadastroBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.example.vamostcc.view.home.home
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore


class frmCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFrmCadastroBinding
    private val auth = FirebaseAuth.getInstance()
    private var db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrmCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnCadastrar.setOnClickListener { view ->

            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()


            if (email.isEmpty() || senha.isEmpty() ) {
                val avisoVazio =
                    Snackbar.make(view, "Preencha todos os Campos", Snackbar.LENGTH_SHORT)
                avisoVazio.setBackgroundTint(Color.RED)
                avisoVazio.show()
            }
            else
                {
                    auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener{ cadastro ->
                        if (cadastro.isSuccessful){
                            val avisoSucesso = Snackbar.make(view, "cadastrado com sucesso", Snackbar.LENGTH_SHORT)
                            avisoSucesso.setBackgroundTint(Color.GREEN)
                            avisoSucesso.show()

                            binding.edtEmail.setText("")
                            binding.edtSenha.setText("")


                            val irparahome = Intent(this, home :: class.java)
                            startActivity(irparahome)
                            finish()

                        }

                    }.addOnFailureListener{exception ->

                        val msgErro = when(exception){
                            is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 8 dígitos"
                            is FirebaseAuthInvalidCredentialsException -> "Digite um email válido"
                            is FirebaseAuthUserCollisionException -> "Este email já está cadastrado"
                            is FirebaseNetworkException -> "Sem conexão com a internet"

                            else -> "Erro ao cadastrar usuário"
                        }
                        val aviso =
                            Snackbar.make(view, msgErro, Snackbar.LENGTH_SHORT)
                        aviso.setBackgroundTint(Color.RED)
                        aviso.show()

                    }

                }

        }


        binding.btnPossuiConta.setOnClickListener{
            var entrar = Intent (this , frmLogin::class.java)
            startActivity(entrar)
        }


    }


}



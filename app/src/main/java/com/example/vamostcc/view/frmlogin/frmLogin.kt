package com.example.vamostcc.view.frmlogin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vamostcc.databinding.ActivityFrmLoginBinding
import com.example.vamostcc.view.frmrecuperarsenha.telaRecuperarSenha
import com.example.vamostcc.view.frmcadastro.frmCadastro
import com.example.vamostcc.view.telaprincipal.telaPrincipal
import com.example.vamostcc.view.telausuario.telaUsuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException


class frmLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFrmLoginBinding

    private val auth = FirebaseAuth.getInstance()

    private fun irPraTelaHome(){
        val telaHome = Intent(this, telaPrincipal::class.java)
        startActivity(telaHome)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrmLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnCriarUsuario.setOnClickListener{
            val intent = Intent(this, frmCadastro::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener {view ->
            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty())
            {
                val snackbar = Snackbar.make(view,"Preencha todos os Campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
            else{
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener{autenticacao ->
                    if (autenticacao.isSuccessful){
                        irPraTelaHome()
                        finish()
                    }
                }.addOnFailureListener {exception ->
                    val msgErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 8 dígitos"
                        is FirebaseAuthInvalidCredentialsException -> "email ou senha incorretos"
                        is FirebaseAuthInvalidUserException -> "usuário não cadastrado"
                        is FirebaseNetworkException -> "Sem conexão com a internet"

                        else -> "Erro ao Logar"
                    }
                    val aviso =
                        Snackbar.make(view, msgErro, Snackbar.LENGTH_SHORT)
                    aviso.setBackgroundTint(Color.RED)
                    aviso.show()

                }

            }

        }


        binding.btnRecuperarSenha.setOnClickListener{
            val intent = Intent(this, telaRecuperarSenha::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        val usuarioAtual = FirebaseAuth.getInstance().currentUser
        if (usuarioAtual != null){
            irPraTelaHome()
        }
        else{

        }

    }
}
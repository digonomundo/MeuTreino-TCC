package com.example.vamostcc.view.telaprincipal.ui.perfilusuario

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vamostcc.databinding.FragmentTelaUsuarioBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class TelaUsuarioFragment : Fragment() {
    private var _binding: FragmentTelaUsuarioBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()
    private var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTelaUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idUsuario = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("usuarios").document(idUsuario)

        ref.get().addOnSuccessListener { document ->
            if (document != null) {
                val nome = document["nome"].toString()
                val peso: Double = document["peso"].toString().toDouble()
                val altura: Double = document["altura"].toString().toDouble()
                val idade = document["idade"].toString().toInt()

                binding.txtNome.text = nome
                binding.txtPeso.text = "$peso kg"
                binding.txtAltura.text = "$altura metros"
                binding.txtIdade.text = "$idade anos"

                val imc = calcularIMC(peso, altura)
                val imcFormatado = formatarImc(imc)
                val agua = calcularAgua(peso)
                val aguaFormatada = formatarAgua(agua)

                binding.txtImc.text = imcFormatado
                binding.txtQtdAgua.text = "$aguaFormatada litros"

                if (imc < 18.5) {
                    binding.txtResultadoImc.setText("você está Abaixo do peso")
                    binding.txtResultadoImc.setTextColor(Color.RED)
                }
                else if (imc >= 18.5 && imc < 24.9) {
                    binding.txtResultadoImc.setText("você está com o peso Saudável")
                    binding.txtResultadoImc.setTextColor(Color.GREEN)
                }
                else if (imc >= 25.0 && imc < 29.9) {
                    binding.txtResultadoImc.setText("você está Sobrepeso")
                    binding.txtResultadoImc.setTextColor(Color.YELLOW)
                }
                else if (imc >= 30.0 && imc < 34.9) {
                    binding.txtResultadoImc.setText("você está começando a virar a Thais Carla")
                    binding.txtResultadoImc.setTextColor(Color.RED)
                }
                else if (imc >= 35.0 && imc < 39.9) {
                    binding.txtResultadoImc.setText("você virou a Thais Carla")
                    binding.txtResultadoImc.setTextColor(Color.RED)
                }
                else {
                    binding.txtResultadoImc.setText("você está pior que a Thais Carla")
                    binding.txtResultadoImc.setTextColor(Color.RED)
                }
            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "erro", Toast.LENGTH_SHORT).show()
        }

        binding.btnDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, frmLogin::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun calcularIMC(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }

    private fun formatarImc(imc: Double): String {
        return String.format(Locale("pt", "BR"), "%.2f", imc)
    }

    private fun calcularAgua(peso: Double): Double {
        return (peso * 35) / 1000
    }

    private fun formatarAgua(agua: Double): String {
        return String.format(Locale("pt", "BR"), "%.2f", agua)
    }
}

package com.example.vamostcc.view.telaprincipal.ui.montagemTreinos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentMontagemAbdomenBinding
import com.example.vamostcc.databinding.FragmentMontagemPeitoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class montagemAbdomen : Fragment() {

    private var _binding: FragmentMontagemAbdomenBinding? = null
    private val binding get() = _binding!!

    private var db = FirebaseFirestore.getInstance()

    val idUser = FirebaseAuth.getInstance().currentUser!!.uid
    val documentReference = db.collection("usuarios").document(idUser)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMontagemAbdomenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.switch1?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalObliquioDeclinado'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalObliquioDeclinado", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalObliquioDeclinado' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalObliquioDeclinado'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalObliquioDeclinado' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalObliquioDeclinado' existe no documento
                if (document.contains("abdominalObliquioDeclinado")) {
                    val valorCampo = document.getString("abdominalObliquioDeclinado")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch1?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }



        binding?.switch2?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalBarraParalela'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalBarraParalela", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalBarraParalela' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalBarraParalela'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalBarraParalela' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalBarraParalela' existe no documento
                if (document.contains("abdominalBarraParalela")) {
                    val valorCampo = document.getString("abdominalBarraParalela")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch2?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch3?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalSupraCabo'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalSupraCabo", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalSupraCabo' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalSupraCabo'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalSupraCabo' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalSupraCabo' existe no documento
                if (document.contains("abdominalSupraCabo")) {
                    val valorCampo = document.getString("abdominalSupraCabo")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch3?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch4?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalSupraBola'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalSupraBola", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalSupraBola' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalSupraBola'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalSupraBola' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalSupraBola' existe no documento
                if (document.contains("abdominalSupraBola")) {
                    val valorCampo = document.getString("abdominalSupraBola")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch4?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }



        binding?.switch5?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalSupraDeclinado'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalSupraDeclinado", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalSupraDeclinado' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalSupraDeclinado'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalSupraDeclinado' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalSupraDeclinado' existe no documento
                if (document.contains("abdominalSupraDeclinado")) {
                    val valorCampo = document.getString("abdominalSupraDeclinado")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch5?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch6?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalSupra'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalSupra", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalSupra' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalSupra'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalSupra' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalSupra' existe no documento
                if (document.contains("abdominalSupra")) {
                    val valorCampo = document.getString("abdominalSupra")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch6?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch7?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'abdominalInfraBanco'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("abdominalInfraBanco", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'abdominalInfraBanco' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'abdominalInfraBanco'", e)
                }
        }

        // Recuperar o valor do campo 'abdominalInfraBanco' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'abdominalInfraBanco' existe no documento
                if (document.contains("abdominalInfraBanco")) {
                    val valorCampo = document.getString("abdominalInfraBanco")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch7?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch8?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'AbdominalSentadoMaquina'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("AbdominalSentadoMaquina", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'AbdominalSentadoMaquina' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'AbdominalSentadoMaquina'", e)
                }
        }

        // Recuperar o valor do campo 'AbdominalSentadoMaquina' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'AbdominalSentadoMaquina' existe no documento
                if (document.contains("AbdominalSentadoMaquina")) {
                    val valorCampo = document.getString("AbdominalSentadoMaquina")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch8?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch9?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'AbdominalInfraPranchaDeclinada'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("AbdominalInfraPranchaDeclinada", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'AbdominalInfraPranchaDeclinada' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'AbdominalInfraPranchaDeclinada'", e)
                }
        }

        // Recuperar o valor do campo 'AbdominalInfraPranchaDeclinada' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'AbdominalInfraPranchaDeclinada' existe no documento
                if (document.contains("AbdominalInfraPranchaDeclinada")) {
                    val valorCampo = document.getString("AbdominalInfraPranchaDeclinada")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch9?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }





}
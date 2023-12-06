package com.example.vamostcc.view.telaprincipal.ui.montagemTreinos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import com.example.vamostcc.databinding.FragmentMontagemPeitoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class montagemPeito : Fragment() {
    private var _binding: FragmentMontagemPeitoBinding? = null
    private val binding get() = _binding!!

    private var db = FirebaseFirestore.getInstance()

    val idUser = FirebaseAuth.getInstance().currentUser!!.uid
    val documentReference = db.collection("usuarios").document(idUser)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMontagemPeitoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.switch1?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'supinoRetoComBarraLivre'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoRetoComBarraLivre", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoRetoComBarraLivre' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoRetoComBarraLivre'", e)
                }
        }

        // Recuperar o valor do campo 'supinoRetoComBarraLivre' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoRetoComBarraLivre' existe no documento
                if (document.contains("supinoRetoComBarraLivre")) {
                    val valorCampo = document.getString("supinoRetoComBarraLivre")

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
            // Lógica para definir o valor do campo 'supinoInclinadoComBarraLivre'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoInclinadoComBarraLivre", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoInclinadoComBarraLivre' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoInclinadoComBarraLivre'", e)
                }
        }

        // Recuperar o valor do campo 'supinoInclinadoComBarraLivre' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoInclinadoComBarraLivre' existe no documento
                if (document.contains("supinoRetoComBarraLivre")) {
                    val valorCampo = document.getString("supinoInclinadoComBarraLivre")

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
            // Lógica para definir o valor do campo 'supinoDeclinadoComBarraLivre'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoDeclinadoComBarraLivre", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoDeclinadoComBarraLivre' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoDeclinadoComBarraLivre'", e)
                }
        }

        // Recuperar o valor do campo 'supinoDeclinadoComBarraLivre' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoDeclinadoComBarraLivre' existe no documento
                if (document.contains("supinoDeclinadoComBarraLivre")) {
                    val valorCampo = document.getString("supinoDeclinadoComBarraLivre")

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
            // Lógica para definir o valor do campo 'supinoRetoComHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoRetoComHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoRetoComHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoRetoComHalter'", e)
                }
        }

        // Recuperar o valor do campo 'supinoRetoComHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoRetoComHalter' existe no documento
                if (document.contains("supinoRetoComHalter")) {
                    val valorCampo = document.getString("supinoRetoComHalter")

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
            // Lógica para definir o valor do campo 'supinoInclinadoComHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoInclinadoComHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoInclinadoComHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoInclinadoComHalter'", e)
                }
        }

        // Recuperar o valor do campo 'supinoInclinadoComHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoInclinadoComHalter' existe no documento
                if (document.contains("supinoInclinadoComHalter")) {
                    val valorCampo = document.getString("supinoInclinadoComHalter")

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
            // Lógica para definir o valor do campo 'supinoDeclinadoComHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoDeclinadoComHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoDeclinadoComHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoDeclinadoComHalter'", e)
                }
        }

        // Recuperar o valor do campo 'supinoDeclinadoComHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoDeclinadoComHalter' existe no documento
                if (document.contains("supinoDeclinadoComHalter")) {
                    val valorCampo = document.getString("supinoDeclinadoComHalter")

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
            // Lógica para definir o valor do campo 'supinoRetoComBarraGuiada'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoRetoComBarraGuiada", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoRetoComBarraGuiada' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoRetoComBarraGuiada'", e)
                }
        }

        // Recuperar o valor do campo 'supinoRetoComBarraGuiada' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'supinoRetoComBarraGuiada' existe no documento
                if (document.contains("supinoRetoComBarraGuiada")) {
                    val valorCampo = document.getString("supinoDeclinadoComHalter")

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
            // Lógica para definir o valor do campo 'supinoInclinadoComBarraGuiada'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("supinoInclinadoComBarraGuiada", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'supinoInclinadoComBarraGuiada' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'supinoInclinadoComBarraGuiada'", e)
                }
        }

        // Recuperar o valor do campo 'supinoInclinadoComBarraGuiada' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'supinoInclinadoComBarraGuiada' existe no documento
                if (document.contains("supinoInclinadoComBarraGuiada")) {
                    val valorCampo = document.getString("supinoInclinadoComBarraGuiada")

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
            // Lógica para definir o valor do campo 'crucifixoSentadoNaMaquina'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("crucifixoSentadoNaMaquina", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'crucifixoSentadoNaMaquina' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoSentadoNaMaquina'", e)
                }
        }

        // Recuperar o valor do campo 'crucifixoSentadoNaMaquina' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'crucifixoSentadoNaMaquina' existe no documento
                if (document.contains("crucifixoSentadoNaMaquina")) {
                    val valorCampo = document.getString("crucifixoSentadoNaMaquina")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch9?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }



        binding?.switch10?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'crucifixoRetoComHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("crucifixoRetoComHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'crucifixoRetoComHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoRetoComHalter'", e)
                }
        }

        // Recuperar o valor do campo 'crucifixoRetoComHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'crucifixoRetoComHalter' existe no documento
                if (document.contains("crucifixoRetoComHalter")) {
                    val valorCampo = document.getString("crucifixoRetoComHalter")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch10?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }


        binding?.switch11?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'crucifixoInclinadoComHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("crucifixoInclinadoComHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'crucifixoInclinadoComHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoInclinadoComHalter'", e)
                }
        }

        // Recuperar o valor do campo 'crucifixoInclinadoComHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'crucifixoInclinadoComHalter' existe no documento
                if (document.contains("crucifixoInclinadoComHalter")) {
                    val valorCampo = document.getString("crucifixoInclinadoComHalter")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch11?.isChecked = (valorCampo == "Selecionado")
                }
            } else {
                Log.d("Firestore", "Documento não encontrado.")
            }
        }.addOnFailureListener { exception ->
            Log.d("Firestore", "Falha ao obter o documento.", exception)
        }
        

        binding?.switch12?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'crucifixoArticuladoNaMaquina'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("crucifixoArticuladoNaMaquina", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'crucifixoArticuladoNaMaquina' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoArticuladoNaMaquina'", e)
                }
        }

        // Recuperar o valor do campo 'crucifixoArticuladoNaMaquina' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'crucifixoArticuladoNaMaquina' existe no documento
                if (document.contains("crucifixoArticuladoNaMaquina")) {
                    val valorCampo = document.getString("crucifixoArticuladoNaMaquina")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch12?.isChecked = (valorCampo == "Selecionado")
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


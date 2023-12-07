package com.example.vamostcc.view.telaprincipal.ui.montagemTreinos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentMontagemAbdomenBinding
import com.example.vamostcc.databinding.FragmentMontagemPernasBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class montagemPernas : Fragment() {

    private var _binding: FragmentMontagemPernasBinding? = null
    private val binding get() = _binding!!

    private var db = FirebaseFirestore.getInstance()

    val idUser = FirebaseAuth.getInstance().currentUser!!.uid
    val documentReference = db.collection("usuarios").document(idUser)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMontagemPernasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.switch1?.setOnCheckedChangeListener { buttonView, isChecked ->
            // Lógica para definir o valor do campo 'agachamentoAfundoHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("agachamentoAfundoHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'agachamentoAfundoHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'agachamentoAfundoHalter'", e)
                }
        }

        // Recuperar o valor do campo 'agachamentoAfundoHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'agachamentoAfundoHalter' existe no documento
                if (document.contains("agachamentoAfundoHalter")) {
                    val valorCampo = document.getString("agachamentoAfundoHalter")

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
            // Lógica para definir o valor do campo 'agachamentoSmith'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("agachamentoSmith", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'agachamentoSmith' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'agachamentoSmith'", e)
                }
        }

        // Recuperar o valor do campo 'agachamentoSmith' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'agachamentoSmith' existe no documento
                if (document.contains("agachamentoSmith")) {
                    val valorCampo = document.getString("agachamentoSmith")

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
            // Lógica para definir o valor do campo 'agachamentoHack'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("agachamentoHack", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'agachamentoHack' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'agachamentoHack'", e)
                }
        }

        // Recuperar o valor do campo 'agachamentoHack' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'agachamentoHack' existe no documento
                if (document.contains("agachamentoHack")) {
                    val valorCampo = document.getString("agachamentoHack")

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
            // Lógica para definir o valor do campo 'elevacaoPelvicaLivre'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("elevacaoPelvicaLivre", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'elevacaoPelvicaLivre' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'elevacaoPelvicaLivre'", e)
                }
        }

        // Recuperar o valor do campo 'elevacaoPelvicaLivre' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'elevacaoPelvicaLivre' existe no documento
                if (document.contains("elevacaoPelvicaLivre")) {
                    val valorCampo = document.getString("elevacaoPelvicaLivre")

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
            // Lógica para definir o valor do campo 'cadeiraFlexora'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("cadeiraFlexora", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'cadeiraFlexora' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'cadeiraFlexora'", e)
                }
        }

        // Recuperar o valor do campo 'cadeiraFlexora' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'cadeiraFlexora' existe no documento
                if (document.contains("cadeiraFlexora")) {
                    val valorCampo = document.getString("cadeiraFlexora")

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
            // Lógica para definir o valor do campo 'mesaFlexora'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("mesaFlexora", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'mesaFlexora' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'mesaFlexora'", e)
                }
        }

        // Recuperar o valor do campo 'mesaFlexora' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'mesaFlexora' existe no documento
                if (document.contains("mesaFlexora")) {
                    val valorCampo = document.getString("mesaFlexora")

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
            // Lógica para definir o valor do campo 'leg45'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("leg45", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'leg45' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'leg45'", e)
                }
        }

        // Recuperar o valor do campo 'leg45' do Firestore
        documentReference.get().addOnSuccessListener { document ->

            if (document != null && document.exists()) {

                // Verificar se o campo 'leg45' existe no documento
                if (document.contains("leg45")) {
                    val valorCampo = document.getString("leg45")

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
            // Lógica para definir o valor do campo 'stiffBarra'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("stiffBarra", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'stiffBarra' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'stiffBarra'", e)
                }
        }

        // Recuperar o valor do campo 'stiffBarra' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'stiffBarra' existe no documento
                if (document.contains("stiffBarra")) {
                    val valorCampo = document.getString("stiffBarra")

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
            // Lógica para definir o valor do campo 'agachamentoAlternadoBarra'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("agachamentoAlternadoBarra", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'agachamentoAlternadoBarra' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'agachamentoAlternadoBarra'", e)
                }
        }

        // Recuperar o valor do campo 'agachamentoAlternadoBarra' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'agachamentoAlternadoBarra' existe no documento
                if (document.contains("agachamentoAlternadoBarra")) {
                    val valorCampo = document.getString("agachamentoAlternadoBarra")

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
            // Lógica para definir o valor do campo 'agachamentoLivreBarra'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("agachamentoLivreBarra", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'agachamentoLivreBarra' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'agachamentoLivreBarra'", e)
                }
        }

        // Recuperar o valor do campo 'agachamentoLivreBarra' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'agachamentoLivreBarra' existe no documento
                if (document.contains("agachamentoLivreBarra")) {
                    val valorCampo = document.getString("agachamentoLivreBarra")

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
            // Lógica para definir o valor do campo 'stiffHalter'
            val ligadoOuDesligado = if (isChecked) {"Selecionado"} else {"Excluído"}

            // Atualizar o valor do campo no Firestore
            documentReference.update("stiffHalter", ligadoOuDesligado)
                .addOnSuccessListener {
                    Log.d("Firestore", "Campo 'stiffHalter' atualizado com sucesso.")
                }
                .addOnFailureListener { e ->
                    Log.w("Firestore", "Erro ao atualizar o campo 'stiffHalter'", e)
                }
        }

        // Recuperar o valor do campo 'stiffHalter' do Firestore
        documentReference.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                // Verificar se o campo 'stiffHalter' existe no documento
                if (document.contains("stiffHalter")) {
                    val valorCampo = document.getString("stiffHalter")

                    // Definir o estado do Switch com base no valor do campo
                    binding?.switch11?.isChecked = (valorCampo == "Selecionado")
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
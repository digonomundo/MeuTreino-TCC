package com.example.vamostcc.view.telaprincipal.ui.montagemTreinos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.FragmentContainer
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentMontagemTreinosBinding
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vamostcc.view.frmlogin.frmLogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class MontagemTreinosFragment : Fragment() {
    private var _binding: FragmentMontagemTreinosBinding? = null
    private val binding get() = _binding!!

    private var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMontagemTreinosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.switch1?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoRetoComBarraLivre' já existe no documento
                    if (document.contains("supinoRetoComBarraLivre")) {
                        // Atualiza o campo 'supinoRetoComBarraLivre' com o novo valor
                        documentReference.update("supinoRetoComBarraLivre", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoRetoComBarraLivre' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoRetoComBarraLivre'", e)
                            }
                    } else {
                        // Cria o campo 'supinoRetoComBarraLivre' e define seu valor
                        documentReference.update("supinoRetoComBarraLivre", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoRetoComBarraLivre' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoRetoComBarraLivre'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }



        binding?.switch2?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoInclinadoComBarraLivre' já existe no documento
                    if (document.contains("supinoInclinadoComBarraLivre")) {
                        // Atualiza o campo 'supinoInclinadoComBarraLivre' com o novo valor
                        documentReference.update("supinoInclinadoComBarraLivre", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoInclinadoComBarraLivre' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoInclinadoComBarraLivre'", e)
                            }
                    } else {
                        // Cria o campo 'supinoInclinadoComBarraLivre' e define seu valor
                        documentReference.update("supinoInclinadoComBarraLivre", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoInclinadoComBarraLivre' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoInclinadoComBarraLivre'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }



        binding?.switch3?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoDeclinadoComBarraLivre' já existe no documento
                    if (document.contains("supinoDeclinadoComBarraLivre")) {
                        // Atualiza o campo 'supinoDeclinadoComBarraLivre' com o novo valor
                        documentReference.update("supinoDeclinadoComBarraLivre", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoDeclinadoComBarraLivre' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoDeclinadoComBarraLivre'", e)
                            }
                    } else {
                        // Cria o campo 'supinoDeclinadoComBarraLivre' e define seu valor
                        documentReference.update("supinoDeclinadoComBarraLivre", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoDeclinadoComBarraLivre' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoDeclinadoComBarraLivre'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }



        binding?.switch4?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoRetoComHalter' já existe no documento
                    if (document.contains("supinoRetoComHalter")) {
                        // Atualiza o campo 'supinoRetoComHalter' com o novo valor
                        documentReference.update("supinoRetoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoRetoComHalter' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoRetoComHalter'", e)
                            }
                    } else {
                        // Cria o campo 'supinoRetoComHalter' e define seu valor
                        documentReference.update("supinoRetoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoRetoComHalter' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoRetoComHalter'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch5?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoInclinadoComHalter' já existe no documento
                    if (document.contains("supinoInclinadoComHalter")) {
                        // Atualiza o campo 'supinoInclinadoComHalter' com o novo valor
                        documentReference.update("supinoInclinadoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoInclinadoComHalter' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoInclinadoComHalter'", e)
                            }
                    } else {
                        // Cria o campo 'supinoInclinadoComHalter' e define seu valor
                        documentReference.update("supinoInclinadoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoInclinadoComHalter' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoInclinadoComHalter'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch6?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoDeclinadoComHalter' já existe no documento
                    if (document.contains("supinoDeclinadoComHalter")) {
                        // Atualiza o campo 'supinoDeclinadoComHalter' com o novo valor
                        documentReference.update("supinoDeclinadoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoDeclinadoComHalter' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoDeclinadoComHalter'", e)
                            }
                    } else {
                        // Cria o campo 'supinoInclinadoComHalter' e define seu valor
                        documentReference.update("supinoDeclinadoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoDeclinadoComHalter' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoDeclinadoComHalter'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch7?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoRetoComBarraGuiada' já existe no documento
                    if (document.contains("supinoRetoComBarraGuiada")) {
                        // Atualiza o campo 'supinoRetoComBarraGuiada' com o novo valor
                        documentReference.update("supinoRetoComBarraGuiada", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoRetoComBarraGuiada' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoRetoComBarraGuiada'", e)
                            }
                    } else {
                        // Cria o campo 'supinoRetoComBarraGuiada' e define seu valor
                        documentReference.update("supinoRetoComBarraGuiada", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoRetoComBarraGuiada' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoRetoComBarraGuiada'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch8?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'supinoInclinadoComBarraGuiada' já existe no documento
                    if (document.contains("supinoInclinadoComBarraGuiada")) {
                        // Atualiza o campo 'supinoInclinadoComBarraGuiada' com o novo valor
                        documentReference.update("supinoInclinadoComBarraGuiada", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoInclinadoComBarraGuiada' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'supinoInclinadoComBarraGuiada'", e)
                            }
                    } else {
                        // Cria o campo 'supinoInclinadoComBarraGuiada' e define seu valor
                        documentReference.update("supinoInclinadoComBarraGuiada", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'supinoInclinadoComBarraGuiada' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'supinoInclinadoComBarraGuiada'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch9?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'crucifixoSentadoNaMaquina' já existe no documento
                    if (document.contains("crucifixoSentadoNaMaquina")) {
                        // Atualiza o campo 'crucifixoSentadoNaMaquina' com o novo valor
                        documentReference.update("crucifixoSentadoNaMaquina", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoSentadoNaMaquina' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoSentadoNaMaquina'", e)
                            }
                    } else {
                        // Cria o campo 'crucifixoSentadoNaMaquina' e define seu valor
                        documentReference.update("crucifixoSentadoNaMaquina", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoSentadoNaMaquina' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'crucifixoSentadoNaMaquina'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch10?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'crucifixoRetoComHalter' já existe no documento
                    if (document.contains("crucifixoRetoComHalter")) {
                        // Atualiza o campo 'crucifixoRetoComHalter' com o novo valor
                        documentReference.update("crucifixoRetoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoRetoComHalter' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoRetoComHalter'", e)
                            }
                    } else {
                        // Cria o campo 'crucifixoRetoComHalter' e define seu valor
                        documentReference.update("crucifixoRetoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoRetoComHalter' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'crucifixoRetoComHalter'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

        binding?.switch11?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'crucifixoInclinadoComHalter' já existe no documento
                    if (document.contains("crucifixoInclinadoComHalter")) {
                        // Atualiza o campo 'crucifixoInclinadoComHalter' com o novo valor
                        documentReference.update("crucifixoInclinadoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoInclinadoComHalter' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoInclinadoComHalter'", e)
                            }
                    } else {
                        // Cria o campo 'crucifixoInclinadoComHalter' e define seu valor
                        documentReference.update("crucifixoInclinadoComHalter", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoInclinadoComHalter' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'crucifixoInclinadoComHalter'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }


        binding?.switch12?.setOnCheckedChangeListener { buttonView, isChecked ->
            val ligadoOuDesligado = if (isChecked) {
                "Selecionado"
            } else {
                "Excluído"
            }

            Toast.makeText(requireContext(), ligadoOuDesligado, Toast.LENGTH_SHORT).show()

            val idUser = FirebaseAuth.getInstance().currentUser!!.uid
            val documentReference = db.collection("usuarios").document(idUser)

            documentReference.get().addOnSuccessListener { document ->
                if (document != null) {
                    // Verifica se o campo 'crucifixoArticuladoNaMaquina' já existe no documento
                    if (document.contains("crucifixoArticuladoNaMaquina")) {
                        // Atualiza o campo 'crucifixoArticuladoNaMaquina' com o novo valor
                        documentReference.update("crucifixoArticuladoNaMaquina", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoArticuladoNaMaquina' atualizado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao atualizar o campo 'crucifixoArticuladoNaMaquina'", e)
                            }
                    } else {
                        // Cria o campo 'crucifixoArticuladoNaMaquina' e define seu valor
                        documentReference.update("crucifixoArticuladoNaMaquina", ligadoOuDesligado)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Campo 'crucifixoArticuladoNaMaquina' criado com sucesso.")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Erro ao criar o campo 'crucifixoArticuladoNaMaquina'", e)
                            }
                    }
                } else {
                    Log.d("Firestore", "Documento não encontrado.")
                }
            }.addOnFailureListener { exception ->
                Log.d("Firestore", "Falha ao obter o documento.", exception)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


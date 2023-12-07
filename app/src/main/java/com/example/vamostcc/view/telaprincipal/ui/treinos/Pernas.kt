package com.example.vamostcc.view.telaprincipal.ui.treinos

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentAbdomenBinding
import com.example.vamostcc.databinding.FragmentPernasBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class Pernas : Fragment() {

    private var _binding: FragmentPernasBinding? = null
    private val binding get() = _binding!!

    private var db = FirebaseFirestore.getInstance()

    val idUsuario = FirebaseAuth.getInstance().currentUser!!.uid
    val ref = db.collection("usuarios").document(idUsuario)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPernasBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnEditar.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_pernas_to_nav_montagem_pernas)
        }



        val Linearlayout1 : LinearLayout = binding.linear1
        Linearlayout1.visibility = View.INVISIBLE

        val Linearlayout2 = binding.linear2
        Linearlayout2.visibility = View.INVISIBLE

        val Linearlayout3 = binding.linear3
        Linearlayout3.visibility = View.INVISIBLE

        val Linearlayout4 = binding.linear4
        Linearlayout4.visibility = View.INVISIBLE

        val Linearlayout5 = binding.linear5
        Linearlayout5.visibility = View.INVISIBLE

        val Linearlayout6 = binding.linear6
        Linearlayout6.visibility = View.INVISIBLE

        val Linearlayout7 = binding.linear7
        Linearlayout7.visibility = View.INVISIBLE

        val Linearlayout8 = binding.linear8
        Linearlayout8.visibility = View.INVISIBLE

        val Linearlayout9 = binding.linear9
        Linearlayout9.visibility = View.INVISIBLE



        ref.get().addOnSuccessListener { document ->
            if (document != null) {
                val agachamentoAfundoHalter = document["agachamentoAfundoHalter"].toString()                     //1
                val agachamentoSmith = document["agachamentoSmith"].toString()           //2
                val agachamentoHack = document["agachamentoHack"].toString()           //3
                val elevacaoPelvicaLivre = document["elevacaoPelvicaLivre"].toString()                             //4
                val cadeiraFlexora = document["cadeiraFlexora"].toString()                   //5
                val mesaFlexora = document["mesaFlexora"].toString()                   //6
                val leg45 = document["leg45"].toString()                   //7
                val stiffBarra = document["stiffBarra"].toString()         //8
                val agachamentoAlternadoBarra = document["agachamentoAlternadoBarra"].toString()                 //9

                val agachamentoLivreBarra = document["agachamentoLivreBarra"].toString()
                val stiffHalter = document["stiffHalter"].toString()



                if (agachamentoAfundoHalter == "Selecionado") {
                    val linearLayout1 = binding.linear1
                    linearLayout1.visibility = View.VISIBLE



                    binding.txtTitulo1.setTextColor(Color.WHITE)
                    binding.txtDesc1.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout1 = binding.linear1
                    linearLayout1.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado

                }


                binding.linear1.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video13")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_abdomen_to_nav_montagem_abdomen)
                    },1000)

                }


                if (agachamentoSmith == "Selecionado") {
                    val linearLayout2 = binding.linear2
                    linearLayout2.visibility = View.VISIBLE
                    val params2 = linearLayout2.layoutParams
                    params2.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout2.layoutParams = params2


                    binding.txtTitulo2.setTextColor(Color.WHITE)
                    binding.txtDesc2.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout2 = binding.linear2
                    linearLayout2.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params2 = linearLayout2.layoutParams
                    params2.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout2.layoutParams = params2
                }


                binding.linear2.setOnClickListener() {


                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video2")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }

                if (agachamentoHack == "Selecionado") {
                    val linearLayout3 = binding.linear3
                    linearLayout3.visibility = View.VISIBLE
                    val params3 = linearLayout3.layoutParams
                    params3.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout3.layoutParams = params3

                    binding.txtTitulo3.setTextColor(Color.WHITE)
                    binding.txtDesc3.setTextColor(Color.MAGENTA)
                } else {
                    val linearLayout3 = binding.linear3
                    linearLayout3.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params3 = linearLayout3.layoutParams
                    params3.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout3.layoutParams = params3
                }

                binding.linear3.setOnClickListener(){
                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video3")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



                if (elevacaoPelvicaLivre == "Selecionado") {
                    val linearLayout4 = binding.linear4
                    linearLayout4.visibility = View.VISIBLE
                    val params4 = linearLayout4.layoutParams
                    params4.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout4.layoutParams = params4


                    binding.txtTitulo4.setTextColor(Color.WHITE)
                    binding.txtDesc4.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout4 = binding.linear4
                    linearLayout4.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params4 = linearLayout4.layoutParams
                    params4.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout4.layoutParams = params4
                }

                binding.linear4.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video4")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



                if (cadeiraFlexora == "Selecionado") {
                    val linearLayout5 = binding.linear5
                    linearLayout5.visibility = View.VISIBLE
                    val params5 = linearLayout5.layoutParams
                    params5.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout5.layoutParams = params5

                    binding.txtTitulo5.setTextColor(Color.WHITE)
                    binding.txtDesc5.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout5 = binding.linear5
                    linearLayout5.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params5 = linearLayout5.layoutParams
                    params5.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout5.layoutParams = params5
                }

                binding.linear5.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video5")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



                if (mesaFlexora == "Selecionado") {
                    val linearLayout6 = binding.linear6
                    linearLayout6.visibility = View.VISIBLE
                    val params6 = linearLayout6.layoutParams
                    params6.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout6.layoutParams = params6

                    binding.txtTitulo6.setTextColor(Color.WHITE)
                    binding.txtDesc6.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout6 = binding.linear6
                    linearLayout6.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params6 = linearLayout6.layoutParams
                    params6.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout6.layoutParams = params6
                }

                binding.linear6.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video6")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



                if (leg45 == "Selecionado") {
                    val linearLayout7 = binding.linear7
                    linearLayout7.visibility = View.VISIBLE
                    val params7 = linearLayout7.layoutParams
                    params7.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout7.layoutParams = params7


                    binding.txtTitulo7.setTextColor(Color.WHITE)
                    binding.txtDesc7.setTextColor(Color.MAGENTA)
                } else {
                    val linearLayout7 = binding.linear7
                    linearLayout7.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params7 = linearLayout7.layoutParams
                    params7.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout7.layoutParams = params7
                }

                binding.linear7.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video7")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



                if (stiffBarra == "Selecionado") {
                    val linearLayout8 = binding.linear8
                    linearLayout8.visibility = View.VISIBLE
                    val params8 = linearLayout8.layoutParams
                    params8.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout8.layoutParams = params8

                    binding.txtTitulo8.setTextColor(Color.WHITE)
                    binding.txtDesc8.setTextColor(Color.MAGENTA)
                } else {
                    val linearLayout8 = binding.linear8
                    linearLayout8.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params8 = linearLayout8.layoutParams
                    params8.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout8.layoutParams = params8
                }

                binding.linear8.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video8")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



                if (agachamentoAlternadoBarra == "Selecionado") {
                    val linearLayout9 = binding.linear9
                    linearLayout9.visibility = View.VISIBLE
                    val params9 = linearLayout9.layoutParams
                    params9.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout9.layoutParams = params9

                    binding.txtTitulo9.setTextColor(Color.WHITE)
                    binding.txtDesc9.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout9 = binding.linear9
                    linearLayout9.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params9 = linearLayout9.layoutParams
                    params9.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout9.layoutParams = params9
                }

                binding.linear9.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video9")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }


                if (agachamentoLivreBarra == "Selecionado") {
                    val linearLayout10 = binding.linear10
                    linearLayout10.visibility = View.VISIBLE
                    val params10 = linearLayout10.layoutParams
                    params10.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout10.layoutParams = params10

                    binding.txtTitulo10.setTextColor(Color.WHITE)
                    binding.txtDesc10.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout10 = binding.linear10
                    linearLayout10.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params10 = linearLayout10.layoutParams
                    params10.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout10.layoutParams = params10
                }

                binding.linear10.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video9")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }


                if (stiffHalter == "Selecionado") {
                    val linearLayout11 = binding.linear11
                    linearLayout11.visibility = View.VISIBLE
                    val params11 = linearLayout11.layoutParams
                    params11.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout11.layoutParams = params11

                    binding.txtTitulo11.setTextColor(Color.WHITE)
                    binding.txtDesc11.setTextColor(Color.MAGENTA)

                } else {
                    val linearLayout11 = binding.linear11
                    linearLayout11.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params11 = linearLayout11.layoutParams
                    params11.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout11.layoutParams = params11
                }

                binding.linear11.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video9")
                                .addOnSuccessListener {
                                    Log.d("Firestore", "Campo 'video' atualizado com sucesso.")
                                }
                                .addOnFailureListener { e ->
                                    Log.w("Firestore", "Erro ao atualizar o campo 'video'", e)
                                }
                        }
                    }

                    Handler(Looper.getMainLooper()).postDelayed({
                        Navigation.findNavController(view).navigate(R.id.action_nav_treinos_to_nav_tela_video)
                    },1000)

                }



            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Erro", Toast.LENGTH_SHORT).show()
        }
    }

}
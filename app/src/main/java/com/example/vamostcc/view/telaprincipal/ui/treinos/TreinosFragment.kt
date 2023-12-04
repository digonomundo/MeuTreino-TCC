package com.example.vamostcc.view.telaprincipal.ui.treinos

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.vamostcc.R

import com.example.vamostcc.databinding.FragmentTreinosBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.example.vamostcc.view.telaprincipal.ui.home.HomeFragment
import com.example.vamostcc.view.telaprincipal.ui.montagemTreinos.MontagemTreinosFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class TreinosFragment : Fragment() {

    private var _binding: FragmentTreinosBinding? = null
    private val binding get() = _binding!!

    private var db = FirebaseFirestore.getInstance()

    val idUsuario = FirebaseAuth.getInstance().currentUser!!.uid
    val ref = db.collection("usuarios").document(idUsuario)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTreinosBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val Linearlayout10 = binding.linear10
        Linearlayout10.visibility = View.INVISIBLE


        ref.get().addOnSuccessListener { document ->
            if (document != null) {
                val supinoRetoComBarraLivre = document["supinoRetoComBarraLivre"].toString()                     //1
                val supinoInclinadoComBarraLivre = document["supinoInclinadoComBarraLivre"].toString()           //2
                val supinoDeclinadoComBarraLivre = document["supinoDeclinadoComBarraLivre"].toString()           //3
                val supinoRetoComHalter = document["supinoRetoComHalter"].toString()                             //4
                val supinoInclinadoComHalter = document["supinoInclinadoComHalter"].toString()                   //5
                val supinoDeclinadoComHalter = document["supinoDeclinadoComHalter"].toString()                   //6
                val supinoRetoComBarraGuiada = document["supinoRetoComBarraGuiada"].toString()                   //7
                val supinoInclinadoComBarraGuiada = document["supinoInclinadoComBarraGuiada"].toString()         //8
                val crucifixoSentadoNaMaquina = document["crucifixoSentadoNaMaquina"].toString()                 //9
                val crucifixoRetoComHalter = document["crucifixoRetoComHalter"].toString()                       //10
                val crucifixoInclinadoComHalter = document["crucifixoInclinadoComHalter"].toString()             //11
                val crucifixoArticuladoNaMaquina = document["crucifixoArticuladoNaMaquina"].toString()           //12


                if (supinoRetoComBarraLivre == "Selecionado") {
                    val linearLayout1 = binding.linear1
                    linearLayout1.visibility = View.VISIBLE
                    val params1 = linearLayout1.layoutParams
                    params1.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout1.layoutParams = params1

                    val imgSupino: Drawable = resources.getDrawable(R.drawable.img_supino)
                    binding.txtTitulo1.text = "Supino Reto"
                    binding.txtTitulo1.setTextColor(Color.BLACK)
                    binding.txtDesc1.setText("Com Barra Livre")
                    binding.txtDesc1.setTextColor(Color.MAGENTA)
                    binding.imageView1.setImageDrawable(imgSupino)
                } else {
                    val linearLayout1 = binding.linear1
                    linearLayout1.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params1 = linearLayout1.layoutParams
                    params1.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout1.layoutParams = params1
                }


                binding.linear1.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                                ref.update("video", "video1")
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


                if (supinoInclinadoComBarraLivre == "Selecionado") {
                    val linearLayout2 = binding.linear2
                    linearLayout2.visibility = View.VISIBLE
                    val params2 = linearLayout2.layoutParams
                    params2.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout2.layoutParams = params2

                    val imgSupinoInclinado: Drawable = resources.getDrawable(R.drawable.supinoinclinado)
                    binding.txtTitulo2.text = "Supino Inclinado"
                    binding.txtTitulo2.setTextColor(Color.BLACK)
                    binding.txtDesc2.setText("Com barra livre")
                    binding.txtDesc2.setTextColor(Color.MAGENTA)
                    binding.imageView2.setImageDrawable(imgSupinoInclinado)
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

                if (supinoDeclinadoComBarraLivre == "Selecionado") {
                    val linearLayout3 = binding.linear3
                    linearLayout3.visibility = View.VISIBLE
                    val params3 = linearLayout3.layoutParams
                    params3.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout3.layoutParams = params3

                    val imgSupinoDeclinado: Drawable = resources.getDrawable(R.drawable.supinodeclinado)
                    binding.txtTitulo3.setText("Supino Declinado")
                    binding.txtTitulo3.setTextColor(Color.BLACK)
                    binding.txtDesc3.setText("Com barra livre")
                    binding.txtDesc3.setTextColor(Color.MAGENTA)
                    binding.imageView3.setImageDrawable(imgSupinoDeclinado)
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



                if (supinoRetoComHalter == "Selecionado") {
                    val linearLayout4 = binding.linear4
                    linearLayout4.visibility = View.VISIBLE
                    val params4 = linearLayout4.layoutParams
                    params4.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout4.layoutParams = params4

                    val imgSupinoRetoComHalter: Drawable = resources.getDrawable(R.drawable.supinoretocomhalter)
                    binding.txtTitulo4.text = "Supino Reto"
                    binding.txtTitulo4.setTextColor(Color.BLACK)
                    binding.txtDesc4.setText("Com Halteres")
                    binding.txtDesc4.setTextColor(Color.MAGENTA)
                    binding.imageView4.setImageDrawable(imgSupinoRetoComHalter)
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



                if (supinoInclinadoComHalter == "Selecionado") {
                    val linearLayout5 = binding.linear5
                    linearLayout5.visibility = View.VISIBLE
                    val params5 = linearLayout5.layoutParams
                    params5.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout5.layoutParams = params5

                    val imgSupinoInclinadoComHalter: Drawable = resources.getDrawable(R.drawable.supinoinclinadocomhalter)
                    binding.txtTitulo5.text = "Supino Inclinado"
                    binding.txtTitulo5.setTextColor(Color.BLACK)
                    binding.txtDesc5.setText("Com Halter")
                    binding.txtDesc5.setTextColor(Color.RED)
                    binding.imageView5.setImageDrawable(imgSupinoInclinadoComHalter)
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



                if (supinoDeclinadoComHalter == "Selecionado") {
                    val linearLayout6 = binding.linear6
                    linearLayout6.visibility = View.VISIBLE
                    val params6 = linearLayout6.layoutParams
                    params6.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout6.layoutParams = params6

                    val imgSupinoDeclinadoComHalter: Drawable = resources.getDrawable(R.drawable.supinodeclinadocomhalter)
                    binding.txtTitulo6.text = "Supino Declinado"
                    binding.txtTitulo6.setTextColor(Color.BLACK)
                    binding.txtDesc6.setText("Com Halteres")
                    binding.txtDesc6.setTextColor(Color.RED)
                    binding.imageView6.setImageDrawable(imgSupinoDeclinadoComHalter)
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



                if (supinoRetoComBarraGuiada == "Selecionado") {
                    val linearLayout7 = binding.linear7
                    linearLayout7.visibility = View.VISIBLE
                    val params7 = linearLayout7.layoutParams
                    params7.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout7.layoutParams = params7

                    val imgSupinoRetoComBarraGuiada: Drawable = resources.getDrawable(R.drawable.supinonabarraguiada)
                    binding.txtTitulo7.text = "Supino Reto"
                    binding.txtTitulo7.setTextColor(Color.BLACK)
                    binding.txtDesc7.setText("Com barra Guiada")
                    binding.txtDesc7.setTextColor(Color.RED)
                    binding.imageView7.setImageDrawable(imgSupinoRetoComBarraGuiada)
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



                if (supinoInclinadoComBarraGuiada == "Selecionado") {
                    val linearLayout8 = binding.linear8
                    linearLayout8.visibility = View.VISIBLE
                    val params8 = linearLayout8.layoutParams
                    params8.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout8.layoutParams = params8

                    val imgSupinoInclinadoComBarraGuiada: Drawable = resources.getDrawable(R.drawable.supinoinclinadonabarraguiada)
                    binding.txtTitulo8.text = "Supino Inclinado"
                    binding.txtTitulo8.setTextColor(Color.BLACK)
                    binding.txtDesc8.setText("Com barra Guiada")
                    binding.txtDesc8.setTextColor(Color.RED)
                    binding.imageView8.setImageDrawable(imgSupinoInclinadoComBarraGuiada)
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



                if (crucifixoSentadoNaMaquina == "Selecionado") {
                    val linearLayout9 = binding.linear9
                    linearLayout9.visibility = View.VISIBLE
                    val params9 = linearLayout9.layoutParams
                    params9.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout9.layoutParams = params9

                    val imgCrucifixoSentadoNaMaquina: Drawable = resources.getDrawable(R.drawable.crucifixosentadonamaquina)
                    binding.txtTitulo9.text = "Crucifixo Sentado"
                    binding.txtTitulo9.setTextColor(Color.BLACK)
                    binding.txtDesc9.setText("Na máquina")
                    binding.txtDesc9.setTextColor(Color.RED)
                    binding.imageView9.setImageDrawable(imgCrucifixoSentadoNaMaquina)
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



                if (crucifixoRetoComHalter == "Selecionado") {
                    val linearLayout10 = binding.linear10
                    linearLayout10.visibility = View.VISIBLE
                    val params10 = linearLayout10.layoutParams
                    params10.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout10.layoutParams = params10

                    val imgCrucifixoRetoComHalter: Drawable = resources.getDrawable(R.drawable.crucifixocomhalter)
                    binding.txtTitulo10.text = "Crucifixo Reto"
                    binding.txtTitulo10.setTextColor(Color.BLACK)
                    binding.txtDesc10.setText("Com Halteres")
                    binding.txtDesc10.setTextColor(Color.RED)
                    binding.imageView10.setImageDrawable(imgCrucifixoRetoComHalter)
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
                            ref.update("video", "video10")
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



                if (crucifixoInclinadoComHalter == "Selecionado") {
                    val linearLayout11 = binding.linear11
                    linearLayout11.visibility = View.VISIBLE
                    val params11 = linearLayout11.layoutParams
                    params11.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout11.layoutParams = params11

                    val imgCrucifixoInclinadoComHalter: Drawable = resources.getDrawable(R.drawable.crucifixoinclinadocomhalter)
                    binding.txtTitulo11.text = "Crucifixo Inclinado"
                    binding.txtTitulo11.setTextColor(Color.BLACK)
                    binding.txtDesc11.setText("Com halteres")
                    binding.txtDesc11.setTextColor(Color.RED)
                    binding.imageView11.setImageDrawable(imgCrucifixoInclinadoComHalter)
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
                            ref.update("video", "video11")
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



                if (crucifixoArticuladoNaMaquina == "Selecionado") {
                    val linearLayout12 = binding.linear12
                    linearLayout12.visibility = View.VISIBLE
                    val params12 = linearLayout12.layoutParams
                    params12.height = ViewGroup.LayoutParams.WRAP_CONTENT // Define a altura como WRAP_CONTENT quando o layout é visível
                    linearLayout12.layoutParams = params12

                    val imgCrucifixoArticuladoNaMaquina: Drawable = resources.getDrawable(R.drawable.crucifixoarticuladonamaquina)
                    binding.txtTitulo12.text = "Crucifixo Articulado"
                    binding.txtTitulo12.setTextColor(Color.BLACK)
                    binding.txtDesc12.setText("Na máquina")
                    binding.txtDesc12.setTextColor(Color.RED)
                    binding.imageView12.setImageDrawable(imgCrucifixoArticuladoNaMaquina)
                } else {
                    val linearLayout12 = binding.linear12
                    linearLayout12.visibility = View.GONE // Ou View.INVISIBLE se desejar que o espaço não seja ocupado
                    val params12 = linearLayout12.layoutParams
                    params12.height = 0 // Define a altura como 0 quando o layout está invisível
                    linearLayout12.layoutParams = params12
                }

                binding.linear12.setOnClickListener(){

                    ref.get().addOnSuccessListener { document ->
                        if (document != null) {
                            ref.update("video", "video12")
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



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.vamostcc.view.telaprincipal.ui.video

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentVideoTreinosBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class videoTreinos : Fragment() {

    private var _binding: FragmentVideoTreinosBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()
    private var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoTreinosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        abrirVideo()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun abrirVideo() {

        val idUsuario = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("usuarios").document(idUsuario)

        ref.get().addOnSuccessListener { document ->

            var video = document["video"].toString()

            if (document != null) {

                if (video == "video1" ){

                    var videoView = binding.videoSelecionado
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.videodog
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)

                    var mediaController = MediaController(requireContext())
                    videoView.setMediaController(mediaController)

                } else if(video == "video2"){

                    var videoView = binding.videoSelecionado
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.videomotiva
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)

                    var mediaController = MediaController(requireContext())
                    videoView.setMediaController(mediaController)

                }

            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "erro", Toast.LENGTH_SHORT).show()
        }



    }

}

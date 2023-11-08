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

    private var videoTreinos: VideoView? = null
    private var controle: MediaController? = null

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

        /*abrirVideo()

*/



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

/*
    private fun abrirVideo(){
        if(controle == null){
            controle = MediaController(this.context)
            controle!!.setAnchorView(this.videoTreinos)
        }

        videoTreinos!!.setMediaController(MediaController)

        videoTreinos!!.setVideoURI(
            Uri.parse("android.resource://"+packageName+)
        )


    }
*/

}
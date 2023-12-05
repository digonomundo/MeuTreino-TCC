package com.example.vamostcc.view.telaprincipal.ui.sobre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vamostcc.R

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.vamostcc.databinding.FragmentDesenvolvedoresBinding
import java.net.URL


class Desenvolvedores : Fragment() {
    private var _binding: FragmentDesenvolvedoresBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDesenvolvedoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView1.setOnClickListener{
            openUrl("https://www.linkedin.com/in/digonomundo/")
        }

        binding.imageView2.setOnClickListener{
            openUrl("https://www.linkedin.com/in/ruanfrazao07/")
        }

        binding.imageView3.setOnClickListener{
            openUrl("https://www.linkedin.com/in/vinicius-pedro-spinola-8922622a3/")
        }

        binding.imageView4.setOnClickListener{
            openUrl("https://www.linkedin.com/in/leonardo-marcolino-0505812a3/")
        }

    }

    private fun openUrl(url: String) {
        var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

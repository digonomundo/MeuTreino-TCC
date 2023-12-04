package com.example.vamostcc.view.telaprincipal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentDesenvolvedoresBinding
import com.example.vamostcc.databinding.FragmentHomeBinding
import com.example.vamostcc.view.telaprincipal.ui.treinos.TreinosFragment
import com.example.vamostcc.view.telaprincipal.ui.montagemTreinos.MontagemTreinosFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

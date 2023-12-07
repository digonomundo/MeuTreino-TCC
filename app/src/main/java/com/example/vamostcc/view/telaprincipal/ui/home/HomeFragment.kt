package com.example.vamostcc.view.telaprincipal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentHomeBinding

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

        binding.btnPeito.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_peito)
        }

        binding.btnAbdomen.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_abdomen)
        }

        binding.btnPerna.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_pernas)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

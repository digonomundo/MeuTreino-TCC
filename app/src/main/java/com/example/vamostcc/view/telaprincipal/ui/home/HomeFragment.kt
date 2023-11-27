package com.example.vamostcc.view.telaprincipal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentHomeBinding
import com.example.vamostcc.view.telaprincipal.ui.treinos.TreinosFragment
import com.example.vamostcc.view.telaprincipal.ui.montagemTreinos.MontagemTreinosFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.txtTela
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    // Substitui o fragmento apenas se não estiver já no HomeFragment
                    if (parentFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName) == null) {
                        substFragm(HomeFragment(), HomeFragment::class.java.simpleName)
                        activity?.title = "Home"
                    }
                }

                R.id.treinos -> {
                    substFragm(TreinosFragment(), TreinosFragment::class.java.simpleName)
                    activity?.title = "Treinos"
                }

                R.id.montagem_treinos -> {
                    substFragm(MontagemTreinosFragment(), MontagemTreinosFragment::class.java.simpleName)
                    activity?.title = "Montagem de Treinos"
                }

                else -> {
                    // Substitui o fragmento apenas se não estiver já no HomeFragment
                    if (parentFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName) == null) {
                        substFragm(HomeFragment(), HomeFragment::class.java.simpleName)
                    }
                }
            }
            true
        }
    }

    private fun substFragm(fragment: Fragment, tag: String) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment, tag)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

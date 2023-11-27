package com.example.vamostcc.view.telaprincipal

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.vamostcc.R
import com.example.vamostcc.databinding.ActivityTelaPrincipalBinding
import com.example.vamostcc.view.home.home
import com.example.vamostcc.view.telaprincipal.ui.home.HomeFragment
import com.example.vamostcc.view.telaprincipal.ui.montagemTreinos.MontagemTreinosFragment
import com.example.vamostcc.view.telaprincipal.ui.perfilusuario.TelaUsuarioFragment
import com.example.vamostcc.view.telaprincipal.ui.treinos.TreinosFragment


class telaPrincipal : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTelaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarTelaPrincipal.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_tela_principal)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_telaUsuario
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //NAVIGATION BUTTOM

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.tela_principal, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_tela_principal)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    /*fun esconderNavigationButton(): Boolean {
        val cardbutton : CardView = binding.cardBottomNav
        cardbutton.visibility = View.INVISIBLE
        return true
    }*/

}
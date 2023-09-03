package com.example.vamostcc.view.splash
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.vamostcc.R
import com.example.vamostcc.view.frmlogin.frmLogin

class telaSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_splash)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, frmLogin::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}
package com.example.modul7_loginwithsharedpreference

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val pindah = Intent(this, LoginActivity::class.java)
            startActivity(pindah)
            finish()
        }, 2000)
        // saat aplikasi pertama kali dibuka ia akan menuju ke splashscreen
        // memiliki delay 2000
        // agar ketika program running munculnya splashscreen maka kita hrs setings di manifest
    }
}
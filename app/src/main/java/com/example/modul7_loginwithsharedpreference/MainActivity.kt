package com.example.modul7_loginwithsharedpreference

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogout: Button = findViewById(R.id.btnLogout)
        val savedLogin = getSharedPreferences("Login", MODE_PRIVATE)
        //savedLogin untuk akses yg sudah disimpan atau SharedPreferences
        val editSavedLogin = savedLogin.edit()
        //editSavedLogin untuk mengubah data yg disimpan

        //saat button logout diklik ia akan melakukan penyimpanan data dan beralih ke login page
        btnLogout.setOnClickListener {
            editSavedLogin.putString("Email", null)
            editSavedLogin.putString("Password", null)
            editSavedLogin.putString("Status", "Off")
            editSavedLogin.commit()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
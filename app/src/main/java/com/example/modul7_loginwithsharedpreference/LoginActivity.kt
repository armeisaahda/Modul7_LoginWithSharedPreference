package com.example.modul7_loginwithsharedpreference

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.modul7_loginwithsharedpreference.DB.DBHelper

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //implementasi getSharedPreferens
        val savedLogin = getSharedPreferences("Login", MODE_PRIVATE)
        //mode private artinya hanya bisa diakses oleh apk itu sendiri
        val editSavedLogin = savedLogin.edit()
        if (savedLogin.getString("Status", "Off")=="On"){
            startActivity(Intent(this, MainActivity::class.java))
        } //ia akan berpindah ke MainActivity ketika status login user bernilai benar

        val editUsername: EditText = findViewById(R.id.EditUsernameLogin)
        val editPassword: EditText = findViewById(R.id.EditPasswordLogin)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnRegister: Button = findViewById(R.id.btnregister)
        val userDBHelper = DBHelper(this)

        btnLogin.setOnClickListener {
            var emailku = editUsername.text.toString()
            var passku = editPassword.text.toString()
            var cekLogin = userDBHelper.cekLogin(emailku, passku)
            if(cekLogin=="1"){
                editSavedLogin.putString("Email", emailku)
                editSavedLogin.putString("Password", passku)
                editSavedLogin.putString("Status", "On")
                editSavedLogin.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val toast: Toast = Toast.makeText(applicationContext,
                    "Gagal Login", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        //button ini akan mengarah ke halaman Register
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
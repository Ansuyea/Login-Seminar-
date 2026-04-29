package com.example.seminarbeary

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.emailLogin)
        val password = findViewById<EditText>(R.id.passwordLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvKeRegistrasi = findViewById<TextView>(R.id.tvPindahRegistrasi)

        btnLogin.setOnClickListener {
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            if (emailText.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.error = "Email tidak valid"
                return@setOnClickListener
            }

            if (passwordText == "admin1") {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("NAMA_USER", "Anisa Ansuya")
                startActivity(intent)
                finish()
            } else {
                password.error = "Password salah!"
                Toast.makeText(this, "Gagal: Password salah.", Toast.LENGTH_SHORT).show()
            }
        }

        tvKeRegistrasi.setOnClickListener {
            startActivity(Intent(this, RegistrasiActivity::class.java))
        }
    }
}
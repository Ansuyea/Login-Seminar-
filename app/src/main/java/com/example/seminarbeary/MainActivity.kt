package com.example.seminarbeary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvNama = findViewById<TextView>(R.id.tvWelcomeNama)
        val btnDaftar = findViewById<Button>(R.id.btnDaftarSeminar)

        val navHome = findViewById<ImageButton>(R.id.navHome)
        val navForm = findViewById<ImageButton>(R.id.navForm)
        val navSuccess = findViewById<ImageButton>(R.id.navSuccess)

        val namaUser = intent.getStringExtra("NAMA_USER") ?: "Anisa Ansuya"
        tvNama.text = "Halo, $namaUser"

        btnDaftar.setOnClickListener {
            startActivity(Intent(this, PendaftaranSeminarActivity::class.java))
        }

        navForm.setOnClickListener {
            startActivity(Intent(this, PendaftaranSeminarActivity::class.java))
        }
        navSuccess.setOnClickListener {
            Toast.makeText(this, "Silahkan daftar seminar terlebih dahulu", Toast.LENGTH_SHORT).show()
        }
    }
}
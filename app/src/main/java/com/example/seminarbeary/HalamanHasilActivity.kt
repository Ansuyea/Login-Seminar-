package com.example.seminarbeary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HalamanHasilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_hasil)

        val resNama = findViewById<TextView>(R.id.resNama)
        val resEmail = findViewById<TextView>(R.id.resEmail)
        val resHp = findViewById<TextView>(R.id.resHp)
        val resGender = findViewById<TextView>(R.id.resGender)
        val resSeminar = findViewById<TextView>(R.id.resSeminar)
        val btnKembali = findViewById<Button>(R.id.btnKembaliMain)

        val navHome = findViewById<ImageButton>(R.id.navHome)
        val navForm = findViewById<ImageButton>(R.id.navForm)

        resNama.text = "Nama: " + intent.getStringExtra("EXTRA_NAMA")
        resEmail.text = "Email: " + intent.getStringExtra("EXTRA_EMAIL")
        resHp.text = "No HP: " + intent.getStringExtra("EXTRA_HP")
        resGender.text = "Gender: " + intent.getStringExtra("EXTRA_GENDER")
        resSeminar.text = "Seminar: " + intent.getStringExtra("EXTRA_SEMINAR")

        btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        navForm.setOnClickListener {
            startActivity(Intent(this, PendaftaranSeminarActivity::class.java))
            finish()
        }
    }
}
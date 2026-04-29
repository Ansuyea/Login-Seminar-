package com.example.seminarbeary

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PendaftaranSeminarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendafar_seminar)

        // View Form
        val etNama = findViewById<EditText>(R.id.etNama)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etNoHp = findViewById<EditText>(R.id.etNoHp)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spSeminar = findViewById<Spinner>(R.id.spSeminar)
        val cbPersetujuan = findViewById<CheckBox>(R.id.cbPersetujuan)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Navbar View
        val navHome = findViewById<ImageButton>(R.id.navHome)
        val navSuccess = findViewById<ImageButton>(R.id.navSuccess)

        // Spinner Setup
        val listSeminar = arrayOf("-- Pilih Seminar --", "Android Dev", "UI/UX", "Cyber Security", "AI 2026", "Cloud")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listSeminar)
        spSeminar.adapter = adapter

        // Realtime HP Validation
        etNoHp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input = s.toString()
                if (input.isNotEmpty()) {
                    if (!input.startsWith("08")) etNoHp.error = "Diawali 08"
                    else if (input.length < 10 || input.length > 13) etNoHp.error = "10-13 digit"
                }
            }
        })

        btnSubmit.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val noHp = etNoHp.text.toString().trim()

            if (nama.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() || etNoHp.error != null || rgGender.checkedRadioButtonId == -1 || !cbPersetujuan.isChecked) {
                Toast.makeText(this, "Lengkapi data dengan benar!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Data sudah benar?")
                .setPositiveButton("Iya") { _, _ ->
                    val intent = Intent(this, HalamanHasilActivity::class.java)
                    intent.putExtra("EXTRA_NAMA", nama)
                    intent.putExtra("EXTRA_EMAIL", email)
                    intent.putExtra("EXTRA_HP", noHp)
                    intent.putExtra("EXTRA_SEMINAR", spSeminar.selectedItem.toString())

                    val rbSelected = findViewById<RadioButton>(rgGender.checkedRadioButtonId)
                    intent.putExtra("EXTRA_GENDER", rbSelected.text.toString())

                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        navSuccess.setOnClickListener {
            Toast.makeText(this, "Selesaikan pendaftaran anda", Toast.LENGTH_SHORT).show()
        }
    }
}
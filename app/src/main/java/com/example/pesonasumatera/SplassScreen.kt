package com.example.pesonasumatera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplassScreen : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splass_screen)

        Handler().postDelayed({
            // Intent untuk pindah ke Activity berikutnya setelah tampilan Splash Screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup Splash Screen
        }, SPLASH_DELAY)
    }
}
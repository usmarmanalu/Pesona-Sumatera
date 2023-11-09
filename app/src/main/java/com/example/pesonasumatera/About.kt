package com.example.pesonasumatera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("About")



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->  {
                onBackPressed()
                return  true
            }else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}